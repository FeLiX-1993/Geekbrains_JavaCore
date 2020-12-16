import test.AfterSuite;
import test.BeforeSuite;
import test.Test;

public class SimpleClass {

    @BeforeSuite
    public void BeforeSuite() {
        System.out.println("Before suite");
    }

    @Test()
    public void test1() {
        System.out.println("Test1");
    }

    @Test(priority = 2)
    public void test2() {
        System.out.println("Test2");
    }

    @Test(priority = 1)
    public void test3() {
        System.out.println("Test3");
    }

    @AfterSuite
    public void AfterSuite() {
        System.out.println("After suite");
    }

}
