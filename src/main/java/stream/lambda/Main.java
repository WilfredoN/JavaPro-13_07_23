package stream.lambda;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Hero> readerCSV() {
        String path = "src/main/resources/heroes.csv";
        List<Hero> heroes = new ArrayList<>();

        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(path))
                .withCSVParser(new CSVParserBuilder()
                        .withSeparator(';')
                        .build())
                .build()) {
            List<String[]> data = csvReader.readAll();
            heroes = data.subList(1, data.size()).stream()
                    .map(row -> new Hero(
                            row[1],
                            row[2],
                            row[3],
                            row[4],
                            row[5],
                            Double.parseDouble(row[6]),
                            row[7],
                            row[8],
                            row[9],
                            Integer.parseInt(row[10])
                    ))
                    .toList();
        } catch (IOException | CsvException e) {
            System.out.println(e.getMessage());
        }
        return heroes;
    }


    public static void main(String[] args) {
        List<Hero> heroes = readerCSV();
        System.out.println("Середня висота - " + Hero.averageHeight(heroes));
        System.out.println("Найвищий герой - " + Hero.highestHero(heroes));
        System.out.println("Найважчий герой - " + Hero.heaviestHero(heroes));
        System.out.println("Розбивка по гендерам - " + Hero.groupByGender(heroes));
        System.out.println("Розбивка по геройству - " + Hero.groupByAlignment(heroes));
        System.out.println("Топ 5 видавництв - " + Hero.topOfPublisher(heroes));
        System.out.println("Топ 3 кольори волосся - " + Hero.topOfHairColor(heroes));
        System.out.println("Топ 1 колір очей - " + Hero.topEyeColor(heroes));
    }
}
