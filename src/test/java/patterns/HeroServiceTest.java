package patterns;

import jdbc.dao.Hero;
import jdbc.dao.HeroDao;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeroServiceTest {

    @Test
    public void ShouldReturnListOfHeroes() {
        HeroDao heroDaoMock = Mockito.mock(HeroDao.class);
        HeroMovieService heroMovieServiceMock = Mockito.mock(HeroMovieService.class);

        HeroService heroService = new HeroService(heroDaoMock, heroMovieServiceMock);

        Mockito.when(heroDaoMock.findAll()).thenReturn(List.of(Hero.builder().name("Tony Stark").build()));
        Mockito.when(heroMovieServiceMock.getPlayedIn("Tony Stark")).thenReturn(List.of("The Avengers"));
        List<HeroDTO> heroes = heroService.getHeroes();
        assertEquals(1, heroes.size());
        assertEquals("Tony Stark", heroes.get(0).getName());
        assertEquals("The Avengers", heroes.get(0).getMovies().get(0));
    }


}