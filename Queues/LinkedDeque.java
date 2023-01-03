public class LinkedDeque<E> implements Deque<E> {

    private final DoublyLinkedList<E> list = new DoublyLinkedList<>();

    @Override
    public void addFirst(E e) {
        list.addFirst(e);
    }

    @Override
    public void addLast(E e) {
        list.addLast(e);
    }

    @Override
    public E removeFirst() {
        return list.removeFirst();
    }

    @Override
    public E removeLast() {
        return list.removeLast();
    }

    @Override
    public E first() {
        return list.first();
    }

    @Override
    public E last() {
        return list.last();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /* ------------------------ DoublyLinkedList Class ------------------------ */

    private static class DoublyLinkedList<T> {

        private Node header;
        private Node trailer;
        private int size;

        public DoublyLinkedList() {
            this.header = new Node(null, null, null);
            this.trailer = new Node(null, header, null);
            header.setNext(trailer);
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
            return header.getNext().getValue();
        }

        public T last() {
            if (isEmpty()) throw new IllegalStateException("LinkedList is empty");
            return trailer.getPrev().getValue();
        }

        private void addBetween(T value, Node before, Node after) {
            Node newNode = new Node(value, before, after);
            before.setNext(newNode);
            after.setPrev(newNode);
            size++;
        }

        public void addFirst(T value) {
            addBetween(value, header, header.getNext());
        }

        public void addLast(T value) {
            addBetween(value, trailer.getPrev(), trailer);
        }

        private T remove(Node node) {
            Node before = node.getPrev();
            Node after = node.getNext();
            before.setNext(after);
            after.setPrev(before);
            size--;
            return node.getValue();
        }

        public T removeFirst() {
            if (isEmpty()) throw new IllegalStateException("LinkedList is empty");
            return remove(header.getNext());
        }

        public T removeLast() {
            if (isEmpty()) throw new IllegalStateException("LinkedList is empty");
            return remove(trailer.getPrev());
        }

        public void traverse() {
            Node node = header.getNext();
            while (node != trailer) {
                System.out.print(node.getValue() + " ");
                node = node.getNext();
            }
            System.out.println();
        }

        /* ------------------------ Getter/Setter ------------------------ */

        public Node getHeader() {
            return header;
        }

        public void setHeader(Node header) {
            this.header = header;
        }

        public Node getTrailer() {
            return trailer;
        }

        public void setTrailer(Node trailer) {
            this.trailer = trailer;
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
            private Node prev;
            private Node next;

            public Node(T v, Node p, Node n) {
                value = v;
                prev = p;
                next = n;
            }

            public T getValue() {
                return value;
            }

            public Node getPrev() {
                return prev;
            }

            public void setPrev(Node prev) {
                this.prev = prev;
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
