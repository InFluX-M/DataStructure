public class ArrayStack<E> implements Stack<E> {

    private static final int CAPACITY = 1000;
    private E[] data;
    private int top = -1;

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public void push(E e) throws IllegalStateException {
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        data[++top] = e;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        E answer = data[top];
        data[top--] = null;
        return answer;
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return data[top];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    private void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        if (size() >= 0)
            System.arraycopy(data, 0, temp, 0, size());
        data = temp;
    }

    public static <E> void reverseArray(E[] arr) {
        ArrayStack<E> buffer = new ArrayStack<>(arr.length);

        for (E e : arr)
            buffer.push(e);

        for (int i = 0; i < arr.length; i++)
            arr[i] = buffer.pop();

    }
}
