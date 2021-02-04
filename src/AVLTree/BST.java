package AVLTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Jaden
 * @time 2021-01-10
 * Binary Search Tree
 */
public class BST<E extends Comparable<E>> {
    /**
     * 本二分搜索树设计中不包含重复元素
     */
    private class Node{
        E e;
        Node left;
        Node right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){
        root = add(root, e);
    }

    // 以node为根节点向树中插入元素e，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, E e){
        if(node == null) {
            size ++;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0)
            // 递归调用
            node.left = add(node.left, e);
        else if(e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }

    public boolean contains(E e){
        return contains(root, e);
    }

    private boolean contains(Node node, E e){
        if(node == null)
            return false;
        if(e.compareTo(node.e) == 0)
            return true;
        if(e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else // e.compareTo(node.e) > 0
            return contains(node.right, e);
    }

    // BST的前序遍历
    // 中 左 右
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        // 递归终止条件
        if(node == null)
            return;

        // 当然也可以不写
        // if(node != null){ ... }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // BST的非递归前序遍历
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }

    }
    // 中序遍历
    // 左 中 右
    public void inOrder(){
        // 遍历后的结果为BST中数值升序结果
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 后序遍历
    // 左 右 中
    // 应用：为BST释放内存
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    // BST的层序遍历，也叫广度优先遍历
    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);

            if(cur.left != null)
                q.add(cur.left);
            if(cur.right != null)
                q.add(cur.right);
        }
    }

    // 寻找BST的最小元素
    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");

        return minimum(root).e;
    }
    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    // 寻找BST最小元素非递归写法
    public E minimumNR(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");
        Node cur = root;
        while (cur.left != null)
            cur = cur.left;
        return cur.e;
    }

    // 寻找BST的最大元素
    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");

        return maximum(root).e;
    }
    private Node maximum(Node node){
        if(node.right == null)
            return node;
        return maximum(node.right);
    }

    // 寻找BST最大元素非递归写法
    public E maximumNR(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");
        Node cur = root;
        while (cur.right != null)
            cur = cur.right;
        return cur.e;
    }

    // 删除BST的最小元素所在节点，返回最小值
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;

            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    // 删除BST的最大元素所在节点，返回最小值
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    // 从BST中删除元素为e的节点
    public void remove(E e){
        root = remove(root, e);
    }

    // 删除以node为根的BST中值为e的节点，递归算法
    // 返回删除节点后新的BST的根
    private Node remove(Node node, E e){
        if(node == null)
            return null;
        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        }
        else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
            return node;
        }
        else {  // e == node.e
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 待删除节点左右均不为空的情况
            // 找到比待删除节点大的最小节点，即待删除节点的右子树的最小节点
            // 用这个节点代替待删除节点的位置

            // 也可以用待删除节点小的最大节点来代替，即待删除节点的左子树的最大节点
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            // size ++;
            successor.left = node.left;
            node.left = node.right = null; // 不写也行
            // size --;这里与上面的++操作抵消
            return successor;
        }

    }

    // 寻找BST中给定数值的floor值
    // 即不超过给定值的最大值，没有则返回null
    public E floor(E e){
        if(size == 0 || e.compareTo(minimum()) < 0)
            return null;
        Node floorNode = floor(root, e);
        return floorNode.e;
    }

    private Node floor(Node node, E e){
        if(node == null)
            return null;
        // 若e == node.e，就是本身
        if(e.compareTo(node.e) == 0)
            return node;
        if(e.compareTo(node.e) < 0){
            return  floor(node.left, e);
        }
        Node res = floor(node.right, e);
        if(res != null) return res;
        return node;
    }

    // 寻找BST中给定数值的ceil值
    // 即不低于给定值的最小值，没有则返回null
    public E ceil(E e){
        if(size == 0 || e.compareTo(maximum()) > 0)
            return null;
        Node ceilNode = ceil(root, e);
        return ceilNode.e;
    }

    private Node ceil(Node node, E e){
        if (node == null)
            return null;
        if(e.compareTo(node.e) == 0)
            return node;
        if(e.compareTo(node.e) > 0)
            return ceil(node.right, e);
        Node resNode = ceil(node.left, e);
        if(resNode != null) return resNode;
        return node;
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }


}
