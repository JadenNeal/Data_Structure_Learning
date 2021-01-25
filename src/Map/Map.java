package Map;

public interface Map<K, V> {
    void add(K key, V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue);  // 设置key对应的值为newValue
    int getSize();
    boolean isEmpty();
}
