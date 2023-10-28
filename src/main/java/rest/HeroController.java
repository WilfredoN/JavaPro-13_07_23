package rest;

import jdbc.dao.Hero;
import jdbc.dao.HeroDao;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HeroController {
    private final HeroDao heroDao;

    @GetMapping("/heroes")
    public List<Hero> getHeroes() {
        return heroDao.findAll();
    }

    @GetMapping("/heroes/{id}")
    public Hero getHero(@PathVariable long id) {
        return heroDao.findById(id);
    }

    @PostMapping("/heroes")
    public void createHero(@RequestBody Hero hero) {
        heroDao.create(hero);
    }

    @PutMapping("/heroes/{id}")
    public void updateHero(@PathVariable long id, @RequestBody Hero hero) {
        heroDao.update(hero);
    }

    @DeleteMapping("/heroes/{id}")
    public void deleteHero(@PathVariable long id) {
        heroDao.delete(id);
    }
}
