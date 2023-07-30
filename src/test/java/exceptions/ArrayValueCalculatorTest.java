package exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayValueCalculatorTest {
    @Test
    void shouldShowCorrectSumOfArray() throws ArrayDataException, ArraySizeException {
        String[][] array = new String[4][4];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = String.valueOf((int) (5 + Math.random() * 20));
                sum += Integer.parseInt(array[i][j]);
            }
        }
        int result = ArrayValueCalculator.doCalc(array);
        assertEquals(sum, result);
    }

    @Test
    void shouldThrowErrorInSomePlace() {
        String[][] array = new String[4][4];
        array[0][0] = "a";
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                array[i][j] = String.valueOf((int) (5 + Math.random() * 20));
            }
        }
        Throwable result = assertThrows(ArrayDataException.class, () -> {
            ArrayValueCalculator.doCalc(array);
        });
        assertNotNull(result.getMessage());
    }
    @Test
    void shouldThrowErrorForArraySize() {
        String[][] array = new String[4][2];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = String.valueOf((int) (5 + Math.random() * 20));
            }
        }
        Throwable result = assertThrows(ArraySizeException.class, () -> ArrayValueCalculator.doCalc(array));
        assertNotNull(result.getMessage());
    }
}