public interface PriorityQueue<K,V>{

    boolean isEmpty();
    void add(K key, V value);
    Entry<K,V> removeMin();
    Entry<K,V> peekMin();
}
