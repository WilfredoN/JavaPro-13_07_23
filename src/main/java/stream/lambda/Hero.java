package stream.lambda;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/*

String name // ім'я
String gender // стать
String eyeColor // колір очей
String race // раса
String hairColor // колір волосся
double height // зріст
String publisher  // видавець
String skinColor // колір шкіри
String alignment // добро / зло
int weight // вага

 */
public record Hero(String name, String gender, String eyeColor, String race, String hairColor, double height,
                   String publisher, String skinColor, String alignment, int weight) {
    public static double averageHeight(List<Hero> heroes) {
        return heroes.stream()
                .filter(h -> h.height > 0)
                .mapToDouble(Hero::height)
                .average()
                .orElse(0.0);
    }

    public static String highestHero(List<Hero> heroes) {
        return heroes.stream()
                .max(comparing(Hero::height))
                .map(Hero::name)
                .orElse("");
    }

    public static String heaviestHero(List<Hero> heroes) {
        return heroes.stream()
                .max(comparing(Hero::weight))
                .map(Hero::name)
                .orElse("");
    }

    public static Map<String, Long> groupByGender(List<Hero> heroes) {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::gender, Collectors.counting()));
    }

    public static Map<String, Long> groupByAlignment(List<Hero> heroes) {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::alignment, Collectors.counting()));
    }

    public static Map<String, Long> topOfPublisher(List<Hero> heroes) {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::publisher, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<String, Long> topOfHairColor(List<Hero> heroes) {
        return heroes.stream()
                .filter(color -> color.hairColor != null)
                .collect(Collectors.groupingBy(Hero::hairColor, Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static String topEyeColor(List<Hero> heroes) {
        return heroes.stream()
                .filter(color -> color.eyeColor != null)
                .collect(Collectors.groupingBy(Hero::eyeColor, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }
}
