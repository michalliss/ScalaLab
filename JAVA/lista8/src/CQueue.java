import java.util.ArrayList;
import java.util.Collections;

public class CQueue<E> implements MyQueue<E> {
    public CQueue(int len) {
        this.array = new ArrayList<>(Collections.nCopies(len+1, null));
        this.f = 0;
        this.r = 0;
    }

    @Override
    public void enqueue(E x) throws FullException {
        if (isFull()) throw new FullException();

        array.set(r, x);
        r = (r + 1) % array.size();
    }

    @Override
    public void dequeue() {
        if (!isEmpty()) {
            f = (f + 1) % array.size();
        }
    }

    @Override
    public E first() throws EmptyException {
        if (isEmpty()) throw new EmptyException();

        return array.get(f);
    }

    @Override
    public boolean isEmpty() {
        return r == f;
    }

    @Override
    public boolean isFull() {
        return r - f == -1 || r - f + 1 == array.size();
    }


    private ArrayList<E> array;
    private int f;
    private int r;
}
