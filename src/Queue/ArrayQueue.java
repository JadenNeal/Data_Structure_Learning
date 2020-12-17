package Queue;

import Array.Array;

/**
 * @author Jaden
 * @time 2020-12-16
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;
    public ArrayQueue(int capacity){
        array = new Array<E>(capacity);
    }
    public ArrayQueue(){
        array = new Array<E>();
    }

    // 3-5 数组队列
    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void enqueue(E e) {

    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E getFront() {
        return null;
    }
}
