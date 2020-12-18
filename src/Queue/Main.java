package Queue;

/**
 * @author Jaden
 * @time 2020-12-17
 */
public class Main {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
        for(int i = 0; i < 10; i ++){
            queue.enqueue(i);
        }
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
    }
}
