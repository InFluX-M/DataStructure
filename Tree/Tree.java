package Tree;

public interface Tree<E> {

    Position<E> root();

    Position<E> parent(Position<E> p);

    Iterable<Position<E>> children(Position<E> p);

    int numChildren(Position<E> p);

    boolean isInternal(Position<E> p);

    boolean isExternal(Position<E> p);

    boolean isRoot(Position<E> p);

    int size();

    boolean isEmpty();

    Iterable<Position<E>> positions();

    interface Position<E> {
        E getElement();

        void setElement(E element);
    }
}
