public class SinglyLinkedList<T> {

    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /* ------------------------ LinkedList Methods ------------------------ */

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T first() {
        if (isEmpty()) throw new IllegalStateException("LinkedList is empty");
        return this.head.getValue();
    }

    public T last() {
        if (isEmpty()) throw new IllegalStateException("LinkedList is empty");
        return this.tail.getValue();
    }

    public void addFirst(T value) {
        head = new Node(value, head);
        if (isEmpty()) tail = head;
        size++;
    }

    public void addLast(T value) {
        Node newNode = new Node(value, null);
        if (isEmpty()) head = newNode;
        else tail.setNext(newNode);
        tail = newNode;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) throw new IllegalStateException("LinkedList is empty");
        T first = head.getValue();
        head = head.getNext();
        size--;
        return first;
    }

    public void traverse() {
        Node node = head;
        while (node != null) {
            System.out.println(node.getValue());
            node = node.getNext();
        }
    }

    /* ------------------------ Getter/Setter ------------------------ */

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /* ------------------------ Node Class ------------------------ */

    class Node {
        private final T value;
        private Node next;

        public Node(T v, Node n) {
            value = v;
            next = n;
        }

        public T getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
