public class ArrayDeque<E> implements Deque<E> {

    private static final int CAPACITY = 1000;
    private final E[] data;
    private int front = 0;
    private int size = 0;

    public ArrayDeque() {
        this(CAPACITY);
    }

    public ArrayDeque(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public void addFirst(E e) {
        if (size == data.length) throw new IllegalStateException("ArrayDeque is full");
        front = (front - 1 + data.length) % data.length;
        data[front] = e;
        size++;
    }

    @Override
    public void addLast(E e) {
        if (size == data.length) throw new IllegalStateException("ArrayDeque is full");
        int avail = (front + size) % data.length;
        data[avail] = e;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) throw new IllegalStateException("ArrayDeque is empty");
        E answer = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return answer;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) throw new IllegalStateException("ArrayDeque is empty");
        int avail = (front + size - 2) % data.length;
        E answer = data[avail];
        data[avail] = null;
        size--;
        return answer;
    }

    @Override
    public E first() {
        if (isEmpty()) throw new IllegalStateException("ArrayDeque is empty");
        return data[front];
    }

    @Override
    public E last() {
        if (isEmpty()) throw new IllegalStateException("ArrayDeque is empty");
        int avail = (front + size - 1) % data.length;
        return data[avail];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
