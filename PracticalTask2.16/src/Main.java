import test.MyTester;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) {

        try {
            MyTester.start(SimpleClass.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
