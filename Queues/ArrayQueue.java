public class ArrayQueue<E> implements Queue<E> {

    private static final int CAPACITY = 1000;
    private E[] data;
    private int front = 0;
    private int size = 0;

    public ArrayQueue() {
        this(CAPACITY);
    }

    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public void enqueue(E e) {
        if (size == data.length) {
            throw new IllegalStateException("Queue is full");
        }
        int avail = (front + size) % data.length;
        data[avail] = e;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        E answer = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return answer;
    }

    @Override
    public E first() {
        if (isEmpty()) return null;
        return data[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = data[(front + i) % data.length];
        }
        data = temp;
        front = 0;
    }
}
