package patterns;

import jdbc.dao.Hero;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroServiceIntegrationTest {
    private final HeroService target = HeroFabric.createService(List.of(
            Hero.builder().id(1L).build(),
            Hero.builder().id(2L).build(),
            Hero.builder().id(3L).build(),
            Hero.builder().id(4L).build()
    ));

    @Test
    void shouldReturnListOfHeroes() {
        var heroDtos = target.getHeroes();
        assertEquals(4, heroDtos.size());
    }
}
