package graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {
    @Test
    void shouldAddDataToTree() {
        Tree tree = new Tree(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        tree.iterateTree();
        assertEquals(5, tree.getData());
        assertEquals(3, tree.getLeftChild().getData());
        assertEquals(7, tree.getRightChild().getData());
        assertNotEquals(1, tree.getLeftChild().getLeftChild().getData());
        assertEquals(4, tree.getLeftChild().getRightChild().getData());
        assertEquals(6, tree.getRightChild().getLeftChild().getData());
        assertEquals(8, tree.getRightChild().getRightChild().getData());
    }
}