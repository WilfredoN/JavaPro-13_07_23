package collections.phonebook;

import java.util.*;


public class PhoneBook {
    private final Map<String, List<String>> records = new HashMap<>();

    public void add(String name, String phoneNumber) {
        if (records.containsKey(name)) {
            records.get(name).add(phoneNumber);
        } else {
            var phoneNumbers = new ArrayList<String>();
            phoneNumbers.add(phoneNumber);
            records.put(name, phoneNumbers);
        }
    }

    public String find(String name) {
        if (records.containsKey(name)) {
            return records.get(name).get(0);
        }
        return null;
    }
    public List<String> findAll(String name) {
        return records.getOrDefault(name, List.of());
    }

    public static void main(String[] args) {
        var phoneBook = new PhoneBook();
        phoneBook.add("Nikita", "380");
        phoneBook.add("Nikita", "431");
        System.out.println(phoneBook.records);
        System.out.println(phoneBook.find("Nikita"));
        System.out.println(phoneBook.findAll("Nikita"));
    }
}
