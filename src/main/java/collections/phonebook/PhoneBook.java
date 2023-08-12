package collections.phonebook;

import java.util.*;

public class PhoneBook {
    private final List<ToNote> records = new ArrayList<>();

    public void add(String name, String phoneNumber) {
        ToNote toNote = findRecordByName(name);
        if (toNote != null) {
            toNote.getPhoneNumber().add(phoneNumber);
        } else {
            var phoneNumbers = new ArrayList<String>();
            phoneNumbers.add(phoneNumber);
            records.add(new ToNote(name, phoneNumbers));
        }
    }

    public String find(String name) {
        ToNote toNote = findRecordByName(name);
        if (toNote != null) {
            return toNote.getPhoneNumber().get(0);
        }
        return null;
    }

    public List<String> findAll(String name) {
        ToNote toNote = findRecordByName(name);
        if (toNote != null) {
            return toNote.getPhoneNumber();
        }
        return List.of();
    }

    private ToNote findRecordByName(String name) {
        for (ToNote toNote : records) {
            if (toNote.getName().equals(name)) {
                return toNote;
            }
        }
        return null;
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
