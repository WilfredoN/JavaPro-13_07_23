package patterns;

import jdbc.dao.Hero;
import jdbc.dao.HeroDao;
import patterns.HeroDTO.HeroDtoBuilder;

import java.util.List;

public class HeroService {
    private final HeroDao heroDao;
    private final HeroMovieService heroMovieService;

    public HeroService(HeroDao heroDao, HeroMovieService heroMovieService) {
        this.heroDao = heroDao;
        this.heroMovieService = heroMovieService;
    }

    public List<HeroDTO> getHeroes() {
        List<Hero> heroes = heroDao.findAll();
        return heroes.stream()
                .map(hero -> new HeroDtoBuilder()
                        .withName(hero.getName())
                        .withMovies(heroMovieService.getPlayedIn(hero.getName()))
                        .build())
                .toList();
    }

    public HeroDTO getHero(long id) {
        return heroDao.findById(id).stream()
                .findFirst()
                .map(hero -> new HeroDtoBuilder()
                        .withName(hero.getName())
                        .withMovies(heroMovieService.getPlayedIn(hero.getName()))
                        .build())
                .orElseThrow(() -> new RuntimeException("Hero not found"));
    }
}
