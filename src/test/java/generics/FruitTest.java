package generics;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class FruitTest {

    @Test
    public void shouldToCalculateTheWeight() throws WrongTypeException {
        Box appleBox = new Box("Apple");
        appleBox.stackTheFruit(new Apple());
        assertEquals(1F, appleBox.getWeight());
        appleBox.stackFruits(Arrays.asList(new Apple(), new Apple()));
        assertEquals(3F, appleBox.getWeight());
        Throwable result = assertThrows(WrongTypeException.class, () -> appleBox.stackTheFruit(new Orange()));
        assertNotNull(result.getMessage());
    }

    @Test
    public void shouldToCompareBoxes() throws WrongTypeException {
        Box appleBox1 = new Box("Orange");
        Box appleBox3 = new Box("Orange");
        Box appleBox2 = new Box("Orange");
        appleBox1.stackFruits(Arrays.asList(new Orange(), new Orange()));
        appleBox3.stackFruits(Arrays.asList(new Orange(), new Orange()));
        appleBox2.stackFruits(Arrays.asList(new Orange(), new Orange(), new Orange()));
        assertFalse(appleBox1.compare(appleBox2));
        assertTrue(appleBox1.compare(appleBox3));
    }

    @Test
    public void shouldToMergeBoxes() throws WrongTypeException {
        Box appleBox1 = new Box("Orange");
        Box appleBox2 = new Box("Orange");
        appleBox1.stackFruits(Arrays.asList(new Orange(), new Orange()));
        appleBox2.stackTheFruit(new Orange());
        appleBox1.merge(appleBox2);
        Float result = appleBox1.getWeight();
        assertEquals(4.5F, result);
    }
}