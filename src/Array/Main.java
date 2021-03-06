/**
 * @author Jaden
 * @time 2020-10-24
 */

// 数组最大的优点：快速查询
//数组最好应用于“索引有语意”的情况
/*
* 索引没有语意，该如何做呢？
* */
package Array;
public class Main {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<Integer>();
        for(int i = 0; i < 10; i ++)
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);
        // [-1,0,100,1,2,3,4,5,6,7,8,9]

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

    }
}
