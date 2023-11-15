package patterns;

import jdbc.dao.Hero;
import jdbc.dao.HeroDao;

import java.util.List;

public class HeroServiceDao {
    private final HeroDao heroDao;

    public HeroServiceDao(HeroDao heroDao) {
        this.heroDao = heroDao;
    }

    public List<Hero> getHeroes() {
        return heroDao.findAll()
                .stream()
                .toList();
    }

    public Hero getByName(String name) {
        return heroDao.findByName(name)
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Hero not found"));
    }

    public Hero getById(long id) {
        return heroDao.findById(id)
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Hero not found"));
    }

    public Hero createHero(Hero hero) {
        heroDao.create(hero);
        return heroDao.findByName(hero.getName()).get(0);
    }

    private Hero findLatestByName(Hero hero) {
        return heroDao.findByName(hero.getName())
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Hero not found"));
    }

    public Hero updateHero(Hero hero) {
        heroDao.update(hero);
        return findLatestByName(hero);
    }

    public void update(Long id, Hero heroDTO) {
        Hero baseHero = getById(id);
        if (baseHero != null) {
            Hero updatedHero = baseHero.toBuilder()
                    .id(heroDTO.getId())
                    .name(heroDTO.getName())
                    .gender(heroDTO.getGender())
                    .eyeColor(heroDTO.getEyeColor())
                    .race(heroDTO.getRace())
                    .hairColor(heroDTO.getHairColor())
                    .height(heroDTO.getHeight())
                    .publisher(heroDTO.getPublisher())
                    .skinColor(heroDTO.getSkinColor())
                    .alignment(heroDTO.getAlignment())
                    .weight(heroDTO.getWeight())
                    .build();

            heroDao.update(updatedHero);
        }
    }

    public void deleteHero(long id) {
        heroDao.delete(id);
    }
}
