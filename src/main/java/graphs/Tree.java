package graphs;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Getter
public class Tree {
    private final int data;
    private Tree leftChild;
    private Tree rightChild;

    public void add(int data) {
        if (data < this.data) {
            if (leftChild == null) {
                leftChild = new Tree(data);
            } else {
                leftChild.add(data);
            }
        } else {
            if (rightChild == null) {
                rightChild = new Tree(data);
            } else {
                rightChild.add(data);
            }
        }
    }

    public void iterateTree() {
        if (leftChild != null) {
            log.info("Лівий нащадок: {}", leftChild.getData());
            leftChild.iterateTree();
        }
        if (rightChild != null) {
            log.info("Правий нащадок: {}", rightChild.getData());
            rightChild.iterateTree();
        }
    }
}
