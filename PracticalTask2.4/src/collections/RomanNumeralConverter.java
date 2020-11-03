package collections;
import java.util.HashMap;

public class RomanNumeralConverter {

    private HashMap<Integer, String> arabicToRomanMap;

    public RomanNumeralConverter() {
        arabicToRomanMap = arabicToRomanMap();
    }

    public String convertArabicToRoman(int value) {

        if (value < 1 || value > 3999) {
            return "";
        }

        String result = "";

        int rank = 1000;
        while (value != 0) {

            int number = value / rank;

            if (number == 0) {
                rank = rank / 10;
                continue;
            } else if (number > 0 && number <= 3)
                for (int i = 1; i <= number; i++)
                    result += arabicToRomanMap.get(rank);
            else if (number == 4)
                result += arabicToRomanMap.get(rank) + arabicToRomanMap.get(rank * 5);
            else if (number >= 5 && number <= 8) {
                result += arabicToRomanMap.get(rank * 5);
                for (int i = 1; i <= number-5; i++)
                    result += arabicToRomanMap.get(rank);
            } else
                result += arabicToRomanMap.get(rank) + arabicToRomanMap.get(rank * 10);

            value = value % rank;
            rank = rank / 10;
        }
        return result;
    }

    private HashMap<Integer, String> arabicToRomanMap() {

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1,"I");
        hashMap.put(5,"V");
        hashMap.put(10,"X");
        hashMap.put(50,"L");
        hashMap.put(100,"C");
        hashMap.put(500,"D");
        hashMap.put(1000,"M");
        return hashMap;

    }
}
