public class CircularQueue<E> implements Queue<E> {

    private CircularlyLinkedList<E> list = new CircularlyLinkedList<>();

    void rotate() {
        list.rotate();
    }

    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }

    @Override
    public E first() {
        return list.first();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /* ------------------------ CircularLinkedList Class ------------------------ */

    private class CircularlyLinkedList<T> {

        private Node head;
        private Node tail;
        private int size;

        public CircularlyLinkedList() {
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

        public void rotate() {
            if (isEmpty()) throw new IllegalStateException("LinkedList is empty");
            tail = head;
            head = head.getNext();
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
            tail.setNext(head);
            size++;
        }

        public void addLast(T value) {
            Node newNode = new Node(value, head);

            if (isEmpty()) {
                head = newNode;
                tail = newNode;
            }

            tail = newNode;
            size++;
        }

        public T removeFirst() {
            if (isEmpty()) throw new IllegalStateException("LinkedList is empty");
            T first = head.getValue();
            head = head.getNext();
            tail.setNext(head);
            size--;
            return first;
        }

        public void traverse() {
            Node node = head;
            do {
                System.out.println(node.getValue());
                node = node.getNext();
            } while (node != head);
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

        private class Node {
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
}
