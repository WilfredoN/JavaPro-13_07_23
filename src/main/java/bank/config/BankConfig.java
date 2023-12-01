package bank.config;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

public class BankConfig {
    public DataSource createDataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setServerNames(new String[]{"localhost"});
        dataSource.setDatabaseName("postgres");
        dataSource.setUser("hillel");
        dataSource.setPassword("hillel");
        return dataSource;
    }
}
