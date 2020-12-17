package Queue;

/**
 * @author Jaden
 * @time 2020-12-16
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
