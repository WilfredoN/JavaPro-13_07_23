package patterns;

import jdbc.dao.Hero;
import jdbc.dao.HeroDao;
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

    public static HeroServiceDao createServiceRest(DataSource dataSource) {
        HeroDao heroDao = new HeroDaoImpl(dataSource);
        return new HeroServiceDao(heroDao);
    }
}
