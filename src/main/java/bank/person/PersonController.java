package bank.person;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping
    public List<PersonDTO> getPersons(Pageable pageable) {
        return personService.getPersons(pageable);
    }

    @GetMapping("/{id}")
    public PersonDTO getPerson(@PathVariable("id") String id) {
        return personService.getPerson(id);
    }

    @PostMapping
    public PersonDTO createPerson(@RequestBody PersonDTO request) {
        return personService.create(request);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") String id) {
        personService.delete(id);
    }

    @PutMapping("/{id}")
    public PersonDTO updatedPerson(
            @PathVariable("id") String id,
            @RequestBody PersonDTO request) {
        return personService.update(id, request);
    }
}
