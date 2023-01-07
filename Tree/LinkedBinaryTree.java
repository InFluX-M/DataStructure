package Tree;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    private Node<E> root;
    private int size;

    public LinkedBinaryTree() {
        this.root = null;
        this.size = 0;
    }

    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<E>(e, parent, left, right);
    }

    protected Node<E> validate(Position<E> p) {
        if (!(p instanceof Node<E> node)) throw new IllegalStateException("Not valid Position type");
        if (node == node.getParent()) throw new IllegalStateException("Not valid Position type");
        return node;
    }

    public Position<E> addRoot(E e) {
        if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    public Position<E> addLeft(Position<E> p, E e) {
        Node<E> node = validate(p);
        if (node.getLeft() != null) throw new IllegalStateException("This node already has a left child");
        Node<E> child = createNode(e, node, null, null);
        node.setLeft(child);
        size++;
        return child;
    }

    public Position<E> addRight(Position<E> p, E e) {
        Node<E> node = validate(p);
        if (node.getRight() != null) throw new IllegalStateException("This node already has a right child");
        Node<E> child = createNode(e, node, null, null);
        node.setRight(child);
        size++;
        return child;
    }

    public E set(Position<E> p, E e) {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) {
        Node<E> node = validate(p);
        if (isInternal(p)) throw new IllegalStateException("node must be leaf");

        size += t1.size() + t2.size();

        if (!t1.isEmpty()) {
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }

        if (!t2.isEmpty()) {
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }

    public E remove(Position<E> p) {
        Node<E> node = validate(p);
        if (numChildren(p) == 2) throw new IllegalStateException("node has 2 children");

        Node<E> child = node.getLeft() == null ? node.getRight() : node.getLeft();

        if (child != null) child.setParent(node.parent);

        if (node == root) root = child;
        else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft()) parent.setLeft(child);
            else parent.setRight(child);
        }

        size--;
        E temp = node.getElement();
        clearNode(node);
        return temp;
    }

    private void clearNode(Node<E> node) {
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node);
    }

    @Override
    public Position<E> left(Position<E> p) {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    @Override
    public Position<E> right(Position<E> p) {
        Node<E> node = validate(p);
        return node.getRight();
    }

    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public Position<E> parent(Position<E> p) {
        Node<E> node = validate(p);
        return node.getParent();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Iterable<Position<E>> positions() {
        return null;
    }

    protected static class Node<E> implements Position<E> {

        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        @Override
        public E getElement() {
            return element;
        }

        @Override
        public void setElement(E element) {
            this.element = element;
        }

        // getter - setter

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }
}
