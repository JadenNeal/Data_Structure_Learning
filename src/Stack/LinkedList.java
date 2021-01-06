package Stack;

/**
 * @author Jaden
 * @time 2020-12-18
 */
public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;  // 指向Node的一个引用

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;  // 虚拟头节点
    int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    // 获取链表中的元素个数
    public int getSize() {
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在链表中间添加元素
    // 但注意链表通常不使用索引，只是练习用
    public void add(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        Node prev = dummyHead;
        // 从head节点一直移动到 index-1 处
        for (int i = 0; i < index; i++)
            prev = prev.next;

        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;

        // prev.next = new Node(e, prev.next);

        size++;

    }

    // 在链表头添加新的元素e
    public void addFirst(E e) {
        add(0, e);
    }

    // 在链表尾添加元素
    public void addLast(E e) {
        add(size, e);
    }

    // 获取链表的第index个位置的元素
    // 不是常用操作
    public E get(int index) {

        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;

        return cur.e;
    }

    // 获取链表第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获取链表最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 修改链表的第index位置的元素为e
    // 不是常用操作，练习用
    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Update failed. Illegal index.");
        Node cur = dummyHead.next;
        for(int i = 0; i < index; i ++)
            cur = cur.next;
        cur.e = e;
    }

    // 查找链表中是否有元素e
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        Node prev = dummyHead;
        for(int i = 0; i < index; i ++)
            prev = prev.next;
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;

        size --;
        return retNode.e;
    }

    // 删除第一个元素
    public E removeFirst(){
        return remove(0);
    }

    // 删除最后一个元素
    public E removeLast(){
        return remove(size - 1);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur  = dummyHead.next;
        while(cur != null){
            res.append(cur + " -> ");
            cur = cur.next;
        }

        // for(Node cur = dummyHead.next; cur != null; cur = cur.next)
        //    res.append(cur + "->");
        res.append("NULL");
        return res.toString();
    }

}

