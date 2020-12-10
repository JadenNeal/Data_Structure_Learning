package Stack;

/**
 * @author Jaden
 * @time 2020-11-29
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
