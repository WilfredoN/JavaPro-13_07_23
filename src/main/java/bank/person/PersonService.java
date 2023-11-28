package bank.person;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public List<PersonDTO> getPersons(Pageable pageable) {
        return personRepository.findAll(pageable).stream()
                .map(this::convertPerson)
                .toList();
    }

    private PersonDTO convertPerson(Person person) {
        return new PersonDTO(person.getUid(), person.getName(), person.getEmail());
    }

    public PersonDTO getPerson(String uid) {
        return personRepository.findByUid(uid)
                .map(this::convertPerson)
                .orElseThrow();
    }

    public PersonDTO create(PersonDTO request) {
        return convertPerson(personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name(request.name())
                .build()));
    }

    public PersonDTO update(String id, PersonDTO request) {
        return personRepository.findByUid(id)
                .map(person -> {
                    person.setName(request.name());
                    return convertPerson(personRepository.save(person));
                })
                .orElseThrow();
    }

    public void delete(String id) {
        var person = personRepository.findByUid(id)
                .orElseThrow();
        personRepository.delete(person);
    }
}
