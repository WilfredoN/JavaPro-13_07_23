package collections.phonebook;

import java.util.List;

public class ToNote {
    private final String name;
    private final List<String> phoneNumber;

    public ToNote(String name, List<String> phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}