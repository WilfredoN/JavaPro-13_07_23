package patterns;

import java.util.List;

public class HeroMovieService {
    public List<String> getPlayedIn(String heroName) {
        return List.of("The Avengers", "Avengers: Age of Ultron", "Avengers: Infinity War", "Avengers: Endgame");
    }
}
