package collections.phonebook;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
    private static Map<String, List<String>> records;
    @BeforeAll
    public static void setup() {
        records = new HashMap<>();
    }
    @Test
    void shouldToHaveName() {
        records.put("Nikita", List.of("380", "320"));
        boolean isContainsKey = records.containsKey("Nikita");
        assertTrue(isContainsKey);
    }
    @Test
    void shouldNotToHaveName() {
        Map<String, List<String>> records = new HashMap<>();
        var phoneBook = new PhoneBook();
        records.put("Nikita", List.of("380", "320"));
        boolean isContainsKey = records.containsKey("NikitA");
        assertFalse(isContainsKey);
    }
    @Test
    void shouldToFindValue() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Nikita", "380");
        String result = phoneBook.find("Nikita");
        assertEquals("380", result);
    }
    @Test
    void shouldNotToFindValue() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Nikita", "380");
        String result = phoneBook.find("Alex");
        assertNull(result);
    }
    @Test
    void findAllNonExistingName() {
        PhoneBook phoneBook = new PhoneBook();
        assertTrue(phoneBook.findAll("Jane").isEmpty());
    }
}