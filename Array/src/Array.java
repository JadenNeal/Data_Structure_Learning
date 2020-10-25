import java.util.Objects;

/**
 * @author Jaden
 * @time 2020-10-24
 */
public class Array<E> {

    private E[] data;  // 现在只能是int类型的
    private int size;

    //构造函数，传入数组的容量capacity构造Array
    public Array(int capacity){
        data = (E[])new Object[capacity];  // 强制类型转换
        size = 0;
    }

    // 无参数的构造函数，默认容量是10
    public Array(){
        this(10); // 10的语意是capacity
    }

    // 获取数组的元素个数
    public int getSize(){
        return size;
    }

    // 获取数组容量
    public int getCapacity(){
        return data.length;
    }

    // 判断数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 向数组末尾添加元素
    public void addLast(E e){
        add(size, e);
    }

    // 向数组最前面添加元素
    public void addFirst(E e){
        add(0, e);
    }

    // 在第index个位置插入元素e
    public void add(int index, E e){

        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size");
        }

        if(size == data.length){
            resize(2 * data.length);
        }

        for(int i = size-1; i >= index; i --){
            data[i+1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    // 获取index位置的元素
    // 通过该方法用户无法知道剩余的容量
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    // 修改index位置的元素为e
    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }

    // 查找数组中是否有e
    public boolean contains(E e){
        for(int i = 0; i < size; i ++){
            if(data[i].equals(e))  // 值比较
                return true;
        }
        return false;
    }

    // 查找数组中e所在的索引，如果不存在e，则返回-1
    public int find(E e){
        for(int i = 0; i < size; i ++){
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    // 从数组中删除index位置的元素e，并返回删除的元素
    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        E ret = data[index];
        for(int i = index + 1; i < size; i ++)
            data[i -1] = data[i];
        size --;
        data[size] = null; // loitering objects != memory leak

        if(size == data.length / 2)
            resize(data.length / 2);
        return ret;
    }

    // 删除数组中第一个元素
    public E removeFirst(){
        return remove(0);
    }

    // 删除数组最后一个元素
    public E removeLast(){
        return remove(size-1);
    }

    // 从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1)
            remove(index);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0; i < size; i ++){
            res.append(data[i]);
            if(i != size -1)
                res.append(",");
        }
        res.append(']');
        return res.toString();
    }

    private void resize(int newCapacity){
        E[] newData =(E[]) new Object[newCapacity];
        for(int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }

}
