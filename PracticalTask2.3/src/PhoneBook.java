import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {

    private HashMap<String, HashSet<String>> data;

    public PhoneBook() {
        data = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {

        HashSet<String> value = data.get(surname);
        if (value == null) {
            value = new HashSet<>();
            value.add(phoneNumber);
        } else {
            value.add(phoneNumber);
        }
        data.put(surname, value);
    }

    public HashSet<String> get(String surname) {
        return data.get(surname);
    }
}
