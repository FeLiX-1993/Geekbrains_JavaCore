import javax.swing.*;

public class Main {

    //1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
    public static void main(String[] args) {

        // 2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
        byte b    = 127;
        short s   = 32767;
        int i     = 2147483647;
        long l    = 7 * 24 * 60 * 60;
        float f   = 45.67f;
        double d  = Math.sqrt(10);
        char c    = 'c';
        boolean bl = true;

        // 3. Написать метод вычисляющий выражение a * (b + (c / d))
        // и возвращающий результат,где a, b, c, d – входные параметры этого метода;
        int i1 = 5;
        int i2 = 7;
        int i3 = 3;
        int i4 = 2;
        float result = calculateExpression(i1,i2,i3,i4);
        System.out.println("3. " + i1 + " * " + "(" + i2 + " + (" + i3  + " / " + i4 + ")) = " + result);

        //4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах
        // от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
        boolean isSumRange10To20 = isSumRange10To20(1,2);
        System.out.println("4. " + isSumRange10To20);

        //5. Написать метод, которому в качестве параметра передается целое число,
        // метод должен напечатать в консоль положительное ли число передали, или отрицательное;
        // Замечание: ноль считаем положительным числом.
        printIsItPositiveValue(-8);

        //6. Написать метод, которому в качестве параметра передается целое число,
        // метод должен вернуть true, если число отрицательное;
        boolean isItNegativeValue = isItNegativeValue(6);
        System.out.println("6. " + isItNegativeValue);

        //7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
        // метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
        printGreeting("Alex");

        //8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
        //Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
        printIsItLeapYear(2020);

    }

    public static float calculateExpression(int a, int b, int c, int d){

        return a * (b + ((float)c / d));

    }

    public static boolean isSumRange10To20(int a, int b){

        int sum = a + b;
        return ((sum >= 10 && sum <= 20) ? true: false);

    }

    public static boolean isItPositiveValue(int a){

        return (a >= 0 ? true: false);

    }

    public static boolean isItNegativeValue(int a){

        return !isItPositiveValue(a);

    }

    public static void printIsItPositiveValue(int a){

        System.out.println("5. " + a + (isItPositiveValue(a) ? " is positive value": " isn't positive value"));

    }

    public static void printGreeting(String name){

        System.out.println("7. Привет, " + name + "!");

    }

    public static void printIsItLeapYear(int year) {

        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
            System.out.println("8. " + year + " is leap");
        else
            System.out.println("8. " + year + " isn't leap");

    }
}
