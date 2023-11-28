package bank.account;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/accounts")
    public List<AccountDTO> getAccounts(Pageable pageable) {
        return accountService.getAccounts(pageable);
    }

    @GetMapping("/person/{personId}/accounts")
    public AccountDTO getAccount(@PathVariable("personId") String personid) {
        return accountService.findByUid(personid);
    }

    @PostMapping("/person/{personId}/accounts")
    public AccountDTO createAccount(@RequestBody AccountDTO request, @PathVariable String personId) {
        return accountService.create(request);
    }

    @PutMapping("/person/{personId}/accounts/{id}")
    public AccountDTO updateAccount(@PathVariable("id") String id, @RequestBody AccountDTO request, @PathVariable String personId) {
        return accountService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable("id") String id) {
        accountService.delete(id);
    }
}
