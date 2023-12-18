package bank.card;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    //TOOD: add custom implementations if needed
    Optional<Card> findByPan(String pan);
}
