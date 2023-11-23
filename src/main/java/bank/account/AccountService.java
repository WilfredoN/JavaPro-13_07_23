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
                account.getBalance(), account.getPersonId().getId());
    }

    public AccountDTO findByUid(String uid) {
        return accountRepository.findByUid(uid)
                .map(this::convertAccount)
                .orElseThrow();
    }

    public List<AccountDTO> findByPersonId(String personId) {
        var person = personRepository.findByUid(personId)
                .orElseThrow();
        return accountRepository.findByPersonId(person).stream()
                .map(this::convertAccount)
                .toList();
    }

    public AccountDTO findByIban(String iban) {
        return accountRepository.findByIban(iban).map(this::convertAccount)
                .orElseThrow();
    }

    public AccountDTO create(AccountDTO request) {
        var person = personRepository.findByUid(request.personId().toString())
                .orElseThrow();
        return convertAccount(accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban(request.iban())
                .balance(request.balance())
                .personId(person)
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
