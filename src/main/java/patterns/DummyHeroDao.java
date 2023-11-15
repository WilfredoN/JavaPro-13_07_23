package patterns;

import jdbc.dao.Hero;
import jdbc.dao.HeroDao;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DummyHeroDao implements HeroDao {
    private final List<Hero> db;

    public List<Hero> findAll() {
        return db;
    }

    public List<Hero> findByName(String name) {
        return db.stream()
                .filter(hero -> hero.getName().equals(name))
                .toList();
    }

    @Override
    public List<Hero> findById(Long id) {
        return db.stream()
                .filter(hero -> hero.getId() == id)
                .toList();
    }

    public void create(Hero hero) {
        db.add(hero);
    }

    public void update(Hero hero) {
        if (delete(hero.getId()))
            db.add(hero);
    }

    public boolean delete(Long id) {
        return db.remove(db.stream()
                .filter(hero -> hero.getId() == id)
                .findFirst()
                .orElseThrow());
    }

}
