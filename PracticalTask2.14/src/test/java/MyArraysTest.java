import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class MyArraysTest {

    @Test
    void numbersAfterLast4() {
        assertArrayEquals(new int[]{1,7},MyArrays.numbersAfterLast4(new int[]{1,2,4,4,2,3,4,1,7}));
        assertArrayEquals(new int[]{2,3,9,1,7},MyArrays.numbersAfterLast4(new int[]{1,2,4,4,2,3,9,1,7}));
        assertArrayEquals(new int[]{},MyArrays.numbersAfterLast4(new int[]{1,2,4,4,2,3,9,1,4}));
        assertThrows(RuntimeException.class, ()->MyArrays.numbersAfterLast4(new int[]{1,2,7,5,2,3,0,1,7}));
    }

    @Test
    void contains1or4() {
        assertEquals(true, MyArrays.contains1or4(new int[]{1}));
        assertEquals(true, MyArrays.contains1or4(new int[]{5,4,-2}));
        assertEquals(false, MyArrays.contains1or4(new int[]{9,6,7}));
        assertEquals(false, MyArrays.contains1or4(new int[]{55,6,7,766}));
    }
}