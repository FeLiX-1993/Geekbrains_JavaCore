public class Main {

    public static void main(String[] args) {

        //1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] arrayTask1 = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i<arrayTask1.length; i++){
            arrayTask1[i] = ((arrayTask1[i]) == 0 ? 1: 0);
        }
        System.out.println("Task 1");
        for (int i = 0; i<arrayTask1.length; i++){
            System.out.print((arrayTask1[i]) + " ");
        }
        System.out.println();

        //2. Задать пустой целочисленный массив размером 8.
        // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] arrayTask2 = new int[8];
        for (int i = 0; i<arrayTask2.length; i++){
            arrayTask2[i] = i * 3;
        }
        System.out.println("Task 2");
        for (int i = 0; i<arrayTask2.length; i++){
            System.out.print((arrayTask2[i]) + " ");
        }
        System.out.println();

        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        // пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] arrayTask3 = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i<arrayTask3.length; i++){
            if (arrayTask3[i] < 6)
                arrayTask3[i] = arrayTask3[i] * 2;
        }
        System.out.println("Task 3");
        for (int i = 0; i<arrayTask3.length; i++){
            System.out.print((arrayTask3[i]) + " ");
        }
        System.out.println();

        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int[][] arrayTask4 = new int[5][5];
        for (int i = 0; i<arrayTask4.length; i++){
            arrayTask4[i][i] = 1;
        }
        System.out.println("Task 4");
        for (int i = 0; i<arrayTask4.length; i++) {
            for (int j = 0; j < arrayTask4[i].length; j++) {
                System.out.print((arrayTask4[i][j]) + "  ");
            }
            System.out.println();
        }

        //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] arrayTask5 = new int[] {99, 5, -3, 2, 11, -101, 5, 2, 598, 8, 9, 1};
        int max = 0;
        int min = 0;
        for (int i = 0; i<arrayTask5.length; i++){
            max = arrayTask5[i] > max ? arrayTask5[i]: max;
            min = arrayTask5[i] < min ? arrayTask5[i]: min;
        }
        System.out.println("Task 5");
        System.out.println("Max value is " + max);
        System.out.println("Min value is " + min);

        //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        // граница показана символами ||, эти символы в массив не входят.
        int[] arrayTask6 = new int[] {2, 2, 2, 1, 2, 2, 10, -7};
        System.out.println("Task 6");
        System.out.println(checkBalance(arrayTask6));

        //7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
        // или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
        // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        int[] arrayTask7 = new int[] {1, 2, 3, 4, 5, 6};
        shiftArray(arrayTask7, -2);
        System.out.println("Task 7");
        for (int i = 0; i<arrayTask7.length; i++){
            System.out.print((arrayTask7[i]) + " ");
        }
        System.out.println();
    }

    public static boolean checkBalance(int[] array){
        if (array.length < 2)
            return true;
        for (int i = 0; i < array.length; i++){
            if (sumOfArrayRange(array,0,i) == sumOfArrayRange(array,i+1,array.length-1))
                return true;
        }
        return false;
    }

    public static void shiftArray(int[] array, int countPos){
        int k;
        if (countPos > 0) {
            for (int i = 0; i < countPos; i++)
                for (int j = array.length - 1; j > 0; j--) {
                    k = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = k;
                }
        } else
            for (int i = 0; i < -countPos; i++)
                for (int j = 0; j < array.length - 1; j++) {
                    k = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = k;
                }
    }

    public static int sumOfArrayRange(int[] array, int start, int end){
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += array[i];
        }
        return sum;
    }

}
