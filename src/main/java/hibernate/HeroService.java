package hibernate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HeroService {
    private final HeroRepository heroRepository;

    public Hero findHero(long id) {
        return heroRepository.findById(id).orElseThrow();
    }
}
