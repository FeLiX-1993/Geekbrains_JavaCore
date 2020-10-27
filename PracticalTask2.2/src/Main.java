public class Main {

    public static void main(String[] args) {

        String[][] array = new String[][] {
            {"6","7","6","7"},
            {"6","7","6","7"},
            {"6","7","6","7"},
            {"6","7","6","f"}
        };

        try {
            int sum = sumTheArray(array);
            System.out.printf("The sum of the array is %s\n", sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.printf("Failed to calculate the sum of the array: %s\n", e.getMessage());
        }
    }

    public static int sumTheArray(String[][] array) {

        int requiredSize = 4;

        if (!checkArraySize(array, requiredSize))
            throw new MyArraySizeException(String.format("The array size is wrong, required: [%s][%s]:",
                    requiredSize,requiredSize));

        int[][] arrayOfInt = new int[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    arrayOfInt[i][j] = Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("Failed to convert \"%s\" [%s][%s] to int",
                            array[i][j],i+1,j+1), e);
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < arrayOfInt.length; i++) {
            for (int j = 0; j < arrayOfInt.length; j++)
                sum += arrayOfInt[i][j];
        }

        return sum;
    }

    public static boolean checkArraySize(String[][] array, int requiredSize) {

        if (array.length != requiredSize)
            return false;

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != requiredSize)
                return false;
        }

        return true;

    }

}
