package optional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeroValueTest {
    @Test
    void shouldToGetHero() {
        HeroValue hero = new HeroValue("A-Bomb", "Male", "yellow", "Human",
                "No Hair", 203, "Marvel Comics",
                "", "good", 441);
        assertEquals("Male", hero.getGender());
    }

}