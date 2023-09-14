package stream.lambda;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeroTest {
    Hero hero1 = new Hero("Adam Monroe", "Male", "blue", null, "Blond",
            -99, "NBC - Heroes", null, "good", -99);
    Hero hero2 = new Hero("Adam Strange", "Male", null, "Human", "Blond",
            185, "DC Comics", null, "evil", 88);
    Hero hero3 = new Hero("Agent 13", "Female", "blue", null, "Blond",
            173, "Marvel Comics", null, "good", 61);
    Hero hero4 = new Hero("Agent Bob", "Male", "brown", "Human", "Brown",
            178, "Marvel Comics", null, "evil", 81);
    Hero hero5 = new Hero("Agent Zero", "Male", "blue", null, null,
            191, "Marvel Comics", null, "good", 104);
    Hero hero6 = new Hero("Agent One", "Male", null, null, null,
            0, "DC Comics", null, "good", 100);
    Hero hero7 = new Hero("Agent Two", "Male", null, null, "Brown",
            0, "Marvel Comics", null, "good", 87);
    List<Hero> heroes = List.of(hero1, hero2, hero3, hero4, hero5, hero6, hero7);

    @Test

    public void shouldGetAverageHeight() {
        assertEquals(181.75, Hero.averageHeight(heroes));
    }

    @Test
    public void shouldGetHighestHeroName() {
        assertEquals("Agent Zero", Hero.highestHero(heroes));
    }

    @Test
    public void shouldGetHeaviestHeroName() {
        assertEquals("Agent Zero", Hero.heaviestHero(heroes));
    }

    @Test
    public void shouldGroupByGender() {
        Map<String, Long> exceptedResult = Hero.groupByGender(heroes);
        assertEquals(6, exceptedResult.get("Male"));
        assertEquals(1, exceptedResult.get("Female"));

    }

    @Test
    public void shouldGroupByAlignment() {
        Map<String, Long> exceptedResult = Hero.groupByAlignment(heroes);
        assertEquals(2, exceptedResult.get("evil"));
        assertEquals(5, exceptedResult.get("good"));
    }

    @Test
    public void shouldShowTopOfPublisher() {
        Map<String, Long> exceptedResult = Hero.topOfPublisher(heroes);
        assertEquals(4, exceptedResult.get("Marvel Comics"));
        assertEquals(2, exceptedResult.get("DC Comics"));
        assertEquals(1, exceptedResult.get("NBC - Heroes"));
    }

    @Test
    public void shouldShowTopOfHairColor() {
        Map<String, Long> exceptedResult = Hero.topOfHairColor(heroes);
        System.out.println(exceptedResult);
        assertEquals(3, exceptedResult.get("Blond"));
        assertEquals(2, exceptedResult.get("Brown"));
    }

    @Test
    public void shouldGetMostPopularEyeColor() {
        assertEquals("blue", Hero.topEyeColor(heroes));
    }
}