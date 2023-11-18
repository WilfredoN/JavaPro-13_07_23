package rest;

import jdbc.dao.Hero;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import patterns.HeroServiceDao;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HeroController {
    private final HeroServiceDao heroService;

    @GetMapping("/heroes")
    public List<Hero> getHeroes() {
        return heroService.getHeroes();
    }

    @GetMapping("/heroes/{id}")
    public Hero getHero(@PathVariable long id) {
        return heroService.getById(id);
    }

    @PostMapping("/heroes")
    public Hero createHero(@RequestBody Hero hero) {
        return heroService.createHero(hero);
    }

    @PutMapping("/heroes/{id}")
    public Hero updateHero(@RequestBody Hero hero) {
        return heroService.update(hero);
    }

    @DeleteMapping("/heroes/{id}")
    public void deleteHero(@PathVariable long id) {
        heroService.deleteHero(id);
    }
}
