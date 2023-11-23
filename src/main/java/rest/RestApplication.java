package rest;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import patterns.HeroFabric;
import patterns.HeroServiceDao;

import javax.sql.DataSource;

//@SpringBootApplication
public class RestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    private static DataSource dataSource() {
        var dataSource = new PGSimpleDataSource();
        dataSource.setDatabaseName("postgres");
        dataSource.setUser("hillel");
        dataSource.setPassword("hillel");
        return dataSource;
    }

    @Bean
    public HeroServiceDao heroService() {
        return HeroFabric.createServiceRest(dataSource());
    }
}
