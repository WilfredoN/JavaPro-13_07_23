package configuration;

import jdbc.dao.HeroDao;
import jdbc.dao.HeroDaoImpl;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import patterns.HeroMovieService;
import patterns.HeroService;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "configuration")
public class HeroConfiguration {
    @Bean
    public DataSource createDataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setDatabaseName("postgres");
        dataSource.setUser("hillel");
        dataSource.setPassword("hillel");
        return dataSource;
    }

    @Bean
    public HeroDao createHeroDao(DataSource dataSource) {
        return new HeroDaoImpl(dataSource);
    }

    @Bean
    public HeroMovieService createHeroMovieService() {
        return new HeroMovieService();
    }

    @Bean
    public HeroService createHeroService(HeroDao heroDao, HeroMovieService heroMovieService) {
        return new HeroService(heroDao, heroMovieService);
    }
}
