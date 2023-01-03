public class DoubleStack<E> {

    private static final int CAPACITY = 1000;

    private E[] data;
    private int top1 = -1;
    private int top2 = CAPACITY;

    public DoubleStack() {
        this(CAPACITY);
    }

    public DoubleStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public void push1(E e) throws IllegalStateException {
        if (size1() + size2() == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        data[++top1] = e;
    }

    public void push2(E e) throws IllegalStateException {
        if (size1() + size2() == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        data[--top2] = e;
    }

    public E pop1() {
        if (isEmpty1()) return null;
        E answer = data[top1];
        data[top1--] = null;
        return answer;
    }

    public E pop2() {
        if (isEmpty2()) return null;
        E answer = data[top2];
        data[top2++] = null;
        return answer;
    }

    public E top1() {
        if (isEmpty1()) return null;
        return data[top1];
    }

    public E top2() {
        if (isEmpty2()) return null;
        return data[top2];
    }

    public int size1() {
        return top1 + 1;
    }

    public int size2() {
        return data.length - top2;
    }

    public boolean isEmpty1() {
        return top1 == -1;
    }

    public boolean isEmpty2() {
        return top2 == data.length;
    }

    private void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        if (size1() >= 0)
            System.arraycopy(data, 0, temp, 0, size1());
        if (size2() >= 0)
            System.arraycopy(data, top2, temp, capacity - size2(), size2());
        data = temp;
    }
}
