import java.util.*;

public class MyHashMap<K, V> implements Map61B<K, V> {
    private int initialSize = 16;
    private double loadFactor = .75;
    private mList<K, V>[] map;
    int size;

    public MyHashMap() {
        clear();
    }

    public MyHashMap(int initialSize) {
        this.initialSize = initialSize;
        clear();
    }

    public MyHashMap(int initialSize, double loadFactor) {
        this.initialSize = initialSize;
        this.loadFactor = loadFactor;
        clear();
    }

    public void clear() {
        map = new mList[initialSize];
        size = 0;
    }

    public boolean containsKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        return get(key) != null;
    }

    private int hash(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        //  abs and avoid overflow
        return (key.hashCode() & 0x7fffffff) % initialSize;
    }

    private mList<K, V> getElement(K key) {
        int hashCode = hash(key);
        mList<K, V> element = map[hashCode];
        while (element != null && !element.getKey().equals(key)) {
            element = element.getNext();
        }
        return element;
    }

    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        mList<K, V> element = getElement(key);
        if (element == null)
            return null;
        return element.getValue();
    }

    public int size() {
        return size;
    }

    public void put(K key, V value) {
        int hashCode = hash(key);
        mList<K, V> element = getElement(key);
        if (element == null) {
            mList<K, V> new_element = new mList<>(hashCode, key, value, map[hashCode]);
            map[hashCode] = new_element;
            size++;
            if (size > initialSize * loadFactor)
                resize(initialSize * 2);
        } else {
            element.setValue(value);
        }
    }

    private void resize(int newSize) {
        MyHashMap<K, V> new_map = new MyHashMap(newSize, loadFactor);
        Set<K> keys = keySet();
        for (K key : keys) {
            new_map.put(key, get(key));
        }
        this.map = new_map.map;
        this.initialSize = newSize;
    }

    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (int i = 0; i < map.length; i++) {
            mList<K, V> element = map[i];
            while (element != null) {
                keys.add(element.getKey());
                element = element.getNext();
            }
        }
        return keys;
    }

    public Iterator<K> iterator() {
        return keySet().iterator();
    }

    @Override
    public V remove(K key) {
        if (key == null)
            throw new IllegalArgumentException();
        int hashCode = hash(key);
        mList<K, V> element = map[hashCode];
        mList<K, V> prev = null;
        while (element != null && !element.getKey().equals(key)) {
            prev = element;
            element = element.getNext();
        }
        if (element == null)
            return null;

        if (prev == null) {
            map[hashCode] = element.getNext();
        } else {
            prev.setNext(element.getNext());
        }
        return element.getValue();
    }

    @Override
    public V remove(K key, V value) {
        if (!get(key).equals(value))
            return null;
        return remove(key);
    }
}