package Tree;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<E>
        extends AbstractTree<E>
        implements BinaryTree<E> {

    public Position<E> sibling(Position<E> p) {
        Position<E> parent = parent(p);
        if (parent == null) return null;
        return left(parent) == null ? right(parent) : left(parent);
    }

    public int numChildren(Position<E> p) {
        int c = 0;
        if (left(p) != null) c++;
        if (right(p) != null) c++;
        return c;
    }

    public Iterable<Position<E>> children(Position<E> p) {
        List<Position<E>> snapshot = new ArrayList<>(2);
        if (left(p) != null) snapshot.add(left(p));
        if (right(p) != null) snapshot.add(right(p));
        return snapshot;
    }

}
