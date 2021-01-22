package BST;

/**
 * @author Jaden
 * @time 2021-01-10
 */
public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        int[] nums = {41, 22, 58, 15, 33, 50, 63, 13, 37, 42, 53};
        for(int num: nums)
            bst.add(num);

        int res = bst.floor(45);
        System.out.println(res);

        System.out.println(bst.ceil(64));

    }
}
