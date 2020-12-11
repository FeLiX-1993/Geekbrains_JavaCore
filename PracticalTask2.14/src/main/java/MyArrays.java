import java.util.Arrays;

public class MyArrays {

    public static int[] numbersAfterLast4(int[] array) {
        int position = -1;
        for (int i = array.length-1; i >= 0; i--) {
            if (array[i]==4) {
                position = i;
                break;
            }
        }

       if (position == -1) {
           throw new RuntimeException("The array doesn't contain 4");
       }

       if (position == array.length-1)
           return new int[]{};
       else
           return Arrays.copyOfRange(array, position+1, array.length);
    }

    public static boolean contains1or4(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1 || array[i] == 4)
                return true;
        }
        return false;
    }

}
