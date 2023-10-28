package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HeroClient {
    public static final String SERVER_HOST = "localhost";
    public static final int SERVER_PORT = 8080;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try (var socket = new Socket(SERVER_HOST, SERVER_PORT);
             var out = new PrintWriter(socket.getOutputStream(), true);
             var in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String inputLine;
            while ((inputLine = scanner.nextLine()) != null) {
                out.println(inputLine);
                if (inputLine.equals("exit")) {
                    break;
                }
                System.out.println(in.readLine());
            }
        }
    }
}