package hometask.generics;

import java.util.ArrayList;
import java.util.Collections;

public class SimpleGenerics {

    public static <T> void swapElementsOfArray(int firstIndex, int secondIndex, T[] array) {

        if (firstIndex > array.length-1 || secondIndex > array.length-1)
            throw new IndexOutOfBoundsException();

        T buffer = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = buffer;

    }

    public static <T> ArrayList<T> arrayToArrayList(T[] array){

        ArrayList<T> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, array);
        return arrayList;

    }

}
