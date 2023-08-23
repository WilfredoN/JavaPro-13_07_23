package generics;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class FruitTest {

    @Test
    public void shouldCalculateTheWeight() {
        Box<Apple> appleBox = new Box<>();
        appleBox.stackTheFruit(new Apple());
        assertEquals(1.0F, appleBox.getWeight());
        appleBox.stackFruits(Arrays.asList(new Apple(), new Apple()));
        assertEquals(3.0F, appleBox.getWeight());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.stackTheFruit(new Orange());
        assertEquals(1.5F, orangeBox.getWeight());
        orangeBox.stackFruits(Arrays.asList(new Orange(), new Orange()));
        assertEquals(4.5F, orangeBox.getWeight());
    }

    @Test
    public void shouldCompareBoxes() {
        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();
        Box<Orange> orangeBox3 = new Box<>();
        orangeBox1.stackFruits(Arrays.asList(new Orange(), new Orange()));
        orangeBox2.stackFruits(Arrays.asList(new Orange(), new Orange(), new Orange()));
        orangeBox3.stackFruits(Arrays.asList(new Orange(), new Orange()));
        assertFalse(orangeBox1.compare(orangeBox2));
        assertTrue(orangeBox1.compare(orangeBox3));
    }

    @Test
    public void shouldMergeBoxes() {
        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();
        orangeBox1.stackFruits(Arrays.asList(new Orange(), new Orange()));
        orangeBox2.stackTheFruit(new Orange());
        orangeBox1.merge(orangeBox2);
        Float result = orangeBox1.getWeight();
        assertEquals(4.5F, result);
    }
}
