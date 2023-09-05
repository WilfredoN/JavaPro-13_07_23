package multithreading.advanced;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleCalculatorTest {
    SimpleCalculator calc = new SimpleCalculator();

    @Test
    public void shouldToCalc() {
        int result = calc.squareSum(2, 2);
        assertEquals(8, result);

    }
}