package server;

import lombok.RequiredArgsConstructor;
import patterns.HeroService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

@RequiredArgsConstructor
public class HeroHandler implements Runnable {
    private final Socket socket;
    private final HeroService heroService;

    @Override
    public void run() {
        System.out.println("З'єднання встановлено!");
        try
                (var out = new PrintWriter(socket.getOutputStream(), true);
                 var in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                if (inputLine.startsWith("exit")) {
                    break;
                } else if (inputLine.startsWith("name")) {
                    String[] words = inputLine.split(" ");
                    words[0] = "";
                    String finalName = String.join(" ", words).trim();
                    var hero = heroService.getHeroes().stream()
                            .filter(h -> h.getName().equals(finalName))
                            .findFirst()
                            .orElse(null);
                    out.println(hero == null ? "Hero not found" : hero);
                } else {
                    out.println("Unknown command");
                }
            }

        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        }

    }
}
