package optional;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeroBuilderTest {
    @Test
    void shouldToGetHero() {
        HeroBuilder hero = HeroBuilder.builder().
                name("A-Bomb")
                .gender("Male")
                .eyeColor("yellow")
                .race("Human")
                .hairColor("No Hair")
                .height(203)
                .publisher("Marvel Comics")
                .skinColor("")
                .alignment("good")
                .weight(441)
                .build();
        List<?> heroes = List.of(hero.getName(), hero.getGender(),
                hero.getEyeColor(), hero.getRace(),
                hero.getHairColor(), hero.getHeight(),
                hero.getPublisher(), hero.getSkinColor(),
                hero.getAlignment(), hero.getWeight());
        assertEquals("yellow", heroes.get(2));
    }
}