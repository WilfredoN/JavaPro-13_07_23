package patterns;

import jdbc.dao.Hero;
import jdbc.dao.HeroDaoImpl;

import javax.sql.DataSource;
import java.util.List;

public class HeroFabric {
    public static HeroService createService(DataSource dataSource) {
        return new HeroService(new HeroDaoImpl(dataSource), new HeroMovieService());
    }

    public static HeroService createService(List<Hero> heroes) {
        return new HeroService(new DummyHeroDao(heroes), new HeroMovieService());
    }
}
