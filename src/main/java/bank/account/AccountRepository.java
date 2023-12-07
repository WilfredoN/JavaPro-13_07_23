package bank.account;

import bank.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUid(String uid);

    Optional<Account> findByIban(String iban);

    Optional<Account> findByPerson(Person personId);

    boolean existsByUid(String accountUid);
}
