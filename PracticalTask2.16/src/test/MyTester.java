package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyTester {

    private MyTester() {
    }

    public static void start(Class metaClass) throws Exception {

        Constructor constructor = metaClass.getConstructor();
        Object object = constructor.newInstance();

        ArrayList<Method> beforeSuiteMethods = new ArrayList<>();
        ArrayList<Method> afterSuiteMethods = new ArrayList<>();
        HashMap<Method, Integer> testMethods = new HashMap<>();

        Method methods[] = metaClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getAnnotation(BeforeSuite.class) != null)
                beforeSuiteMethods.add(method);
            if (method.getAnnotation(AfterSuite.class) != null)
                afterSuiteMethods.add(method);
            if (method.getAnnotation(Test.class) != null)
                testMethods.put(method, method.getAnnotation(Test.class).priority());
        }

        if (beforeSuiteMethods.size() > 1)
            throw new RuntimeException("BeforeSuite annotation must be in a single copy");

        if (afterSuiteMethods.size() > 1)
            throw new RuntimeException("AfterSuite annotation must be in a single copy");

        if (beforeSuiteMethods.size() > 0)
            beforeSuiteMethods.get(0).invoke(object);

        for (int i = 1; i <= Test.MIN_PRIORITY; i++) {
            for (Map.Entry<Method, Integer> testMethodEntry : testMethods.entrySet()) {
                if (i == testMethodEntry.getValue())
                    testMethodEntry.getKey().invoke(object);
            }
        }

        if (afterSuiteMethods.size() > 0)
            afterSuiteMethods.get(0).invoke(object);

    }
}
