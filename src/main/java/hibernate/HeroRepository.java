package hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {
    Optional<Hero> findById(long id);
}
