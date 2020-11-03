package collections;
import java.util.*;

public class MapComparatorByValue implements Comparator {

    private Map<Object,Object> map;

    public MapComparatorByValue(Map<Object, Object> map) {
        this.map = map;
    }

    @Override
    public int compare(Object o1, Object o2) {

        Comparable value1 = (Comparable)map.get(o1);
        Comparable value2 = (Comparable)map.get(o2);

        return value1.compareTo(value2);
    }
}
