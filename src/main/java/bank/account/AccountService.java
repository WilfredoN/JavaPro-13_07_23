package bank.account;

import bank.person.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final PersonRepository personRepository;

    public List<AccountDTO> getAccounts(Pageable pageable) {
        return accountRepository.findAll(pageable).stream()
                .map(this::convertAccount)
                .toList();
    }

    private AccountDTO convertAccount(Account account) {
        return new AccountDTO(account.getUid(), account.getIban(),
                account.getBalance(), account.getPerson().getUid());
    }

    public List<AccountDTO> getAccountsOfPerson(String uid) {
        var person = personRepository.findByUid(uid)
                .orElseThrow();
        return accountRepository.findAll().stream()
                .map(this::convertAccount)
                .filter(account -> account.personId().equals(person.getUid()))
                .toList();
    }

    public List<AccountDTO> findByPersonId(String personId) {
        var person = personRepository.findByUid(personId)
                .orElseThrow();
        return accountRepository.findByPerson(person).stream()
                .map(this::convertAccount)
                .toList();
    }

    public AccountDTO findByIban(String iban) {
        return accountRepository.findByIban(iban).map(this::convertAccount)
                .orElseThrow();
    }

    public AccountDTO create(AccountDTO request, String personId) {
        var person = personRepository.findByUid(personId)
                .orElseThrow();
        return convertAccount(accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban(request.iban())
                .balance(request.balance())
                .person(person)
                .build()));
    }

    public void delete(String id) {
        var account = accountRepository.findByUid(id)
                .orElseThrow();
        accountRepository.delete(account);
    }

    public AccountDTO update(String id, AccountDTO request) {
        return accountRepository.findByUid(id)
                .map(account -> {
                    account.setBalance(request.balance());
                    return convertAccount(accountRepository.save(account));
                })
                .orElseThrow();
    }
}
