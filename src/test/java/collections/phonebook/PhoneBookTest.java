package collections.phonebook;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
    @Test
    void shouldToHaveName() {
        var phoneBook = new PhoneBook();
        phoneBook.add("Nikita", "380");
        assertTrue(phoneBook.findAll("Nikita").contains("380"));
    }

    @Test
    void shouldNotToHaveName() {
        var phoneBook = new PhoneBook();
        phoneBook.add("Nikita", "380");
        assertFalse(phoneBook.findAll("NikitA").contains("380"));
    }

    @Test
    void shouldToFindValue() {
        var phoneBook = new PhoneBook();
        phoneBook.add("Nikita", "380");
        String result = phoneBook.find("Nikita");
        assertEquals("380", result);
    }

    @Test
    void shouldNotToFindValue() {
        var phoneBook = new PhoneBook();
        phoneBook.add("Nikita", "380");
        String result = phoneBook.find("Alex");
        assertNull(result);
    }

    @Test
    void findAllNonExistingName() {
        var phoneBook = new PhoneBook();
        assertTrue(phoneBook.findAll("Jane").isEmpty());
    }
}
