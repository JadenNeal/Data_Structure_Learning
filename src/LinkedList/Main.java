package LinkedList;

/**
 * @author Jaden
 * @time 2020-12-18
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        for(int i = 0; i < 10; i++){
            linkedList.addFirst(i);
        }
        System.out.println(linkedList);
        linkedList.add(2, 2080);
        System.out.println(linkedList);
    }
}
