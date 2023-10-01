package optional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeroLombokTest {
    @Test
    void shouldToGetHero() {
        HeroLombok hero = new HeroLombok();
        hero.setName("A-Bomb");
        hero.setGender("Male");
        hero.setEyeColor("yellow");
        hero.setRace("Human");
        hero.setHairColor("No Hair");
        hero.setHeight(203);
        hero.setPublisher("Marvel Comics");
        hero.setSkinColor("");
        hero.setAlignment("good");
        hero.setWeight(441);
        assertEquals("A-Bomb", hero.getName());
        assertEquals("Male", hero.getGender());
    }


}