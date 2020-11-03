package collections;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        //* 2. Создать TreeMap<String, Integer>. Данная коллекция по-умолчанию сортирует по ключу.
        // Сделать так, чтобы сортировка производилась на значению.
        // К примеру, при значениях 3, 10, 1 (значения ключений могут быть любыми) toString
        // будет выводить всю структуру отсортированную по значениями {"4"=1}, {"101"=3}, {"-1"=10}
        TreeMap<Object, Object> treeMap = new TreeMap<>();
        treeMap.put("101", 3);
        treeMap.put("-1", 10);
        treeMap.put("4", 1);
        treeMap.put("7", -1);
        treeMap.put("11", -8);
        System.out.println(sortedTreeMapByValue(treeMap));

        //** 3. Коллекция содержит цифры римского алфавита, в соответствии таблице соответствия:
        // I - 1, V - 5, X - 10, L - 50, C - 100, D - 500, M - 1000.
        // Реализовать конвертор арабских цифр в диапазоне от 1 до 10 в римские (т.е. 9 станет IX, 4 - IV).
        // Все должно происходить динамические без привязки на "хадркоженные" значения, с перспективой,
        // что мы будем делать любые числа в диапазоне от 1 до N.
        RomanNumeralConverter converter = new RomanNumeralConverter();
        System.out.println(converter.convertArabicToRoman(676));
        System.out.println(converter.convertArabicToRoman(4));
        System.out.println(converter.convertArabicToRoman(2544));

    }

    public static TreeMap<Object, Object> sortedTreeMapByValue(TreeMap<Object, Object> treeMap) {

        MapComparatorByValue comparator = new MapComparatorByValue(treeMap);
        TreeMap<Object, Object> sortedTreeMapByValue = new TreeMap<>(comparator);
        sortedTreeMapByValue.putAll(treeMap);

        return sortedTreeMapByValue;
    }
}
