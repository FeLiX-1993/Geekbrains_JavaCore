import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {


    @Test
    void add() {
        assertEquals(7, MyMath.add(3,4));
    }

    @CsvSource({
            "8,2,4",
            "10,5,2",
            "16,2,8"
    })
    @ParameterizedTest
    void sub(int a, int b, int result) {
        assertEquals(result, MyMath.sub(a,b));
    }

    @MethodSource("dataForSubOperation")
    @ParameterizedTest
    void multi(int a, int b, int result) {
        assertEquals(result, MyMath.multi(a,b));
    }

    public static Stream<Arguments> dataForSubOperation() {
        List<Arguments> arguments = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int a = (int) (Math.random() * 1000);
            int b = (int) (Math.random() * 1000);
            int result = a*b;
            arguments.add(Arguments.arguments(a,b,result));
        }
        return arguments.stream();
    }
}