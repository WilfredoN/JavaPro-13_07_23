package server;

import lombok.RequiredArgsConstructor;
import org.postgresql.ds.PGSimpleDataSource;
import patterns.HeroFabric;
import patterns.HeroService;

import javax.sql.DataSource;
import java.io.IOException;
import java.net.ServerSocket;

@RequiredArgsConstructor
public class HeroServer {
    public static final int SERVER_PORT = 8080;


    public static void main(String[] args) throws IOException {
        HeroService heroService = HeroFabric.createService(dataSource());

        try (var serverSocket = new ServerSocket(SERVER_PORT)) {
            while (true) {
                var socket = serverSocket.accept();
                var handler = new HeroHandler(socket, heroService);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Server stopped");
        }
    }

    private static DataSource dataSource() {
        var dataSource = new PGSimpleDataSource();
        dataSource.setDatabaseName("postgres");
        dataSource.setUser("hillel");
        dataSource.setPassword("hillel");
        return dataSource;
    }
}
