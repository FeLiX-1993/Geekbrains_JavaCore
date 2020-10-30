import java.util.*;

public class Main {

    public static void main(String[] args) {

        String[] words = new String[] {"car","tree","house","cat", "month","mother","place","meal","car"};
        printUniqueWords(words, false);
        printUniqueWords(words, true);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Jackson", "4-75-00");
        phoneBook.add("Peterson", "4-76-67");
        phoneBook.add("Jordan", "4-80-42");
        phoneBook.add("Jordan", "4-80-43");
        phoneBook.add("Morgan", "4-00-77");
        phoneBook.add("Old", "4-75-00");

        System.out.println(phoneBook.get("Jordan"));
        System.out.println(phoneBook.get("Old"));

    }

    static void printUniqueWords(String[] words, boolean withCountOccurrence) {

        if (withCountOccurrence) {

            HashMap<String, Integer> wordsMap = new HashMap<>();
            for (String word: words) {
                Integer value = wordsMap.get(word);
                wordsMap.put(word,value == null ? 1 : value + 1);
            }
            System.out.println(wordsMap);

        } else {

            HashSet<String> wordsSet = new HashSet<>(Arrays.asList(words));
            System.out.println(wordsSet);

        }
    }

}
