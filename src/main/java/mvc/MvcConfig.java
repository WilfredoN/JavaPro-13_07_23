package mvc;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import patterns.HeroFabric;
import patterns.HeroServiceDao;

import javax.sql.DataSource;

@Configuration
public class MvcConfig {
    @Bean
    public HeroServiceDao heroServiceDao() {
        return HeroFabric.createServiceRest(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUser("hillel");
        dataSource.setPassword("hillel");
        return dataSource;
    }
}
