import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private Node root;

    private class Node {
        K key;
        V val;
        Node left, right;
        int size;

        Node(K key, V val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public BSTMap() {
    }

    public void clear() {
        root = null;
    }

    public boolean containsKey(K key) {
        if (key == null)
            throw new IllegalArgumentException("key is null");
        return get(key) != null;
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node x, K key) {
        if (key == null)
            throw new IllegalArgumentException("key is null");
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    public int size() {
        if (root == null) return 0;
        return root.size;
    }

    public int size(Node x) {
        if (x == null) return 0;
        return x.size;
    }

    public void put(K key, V val) {
        if (key == null)
            throw new IllegalArgumentException("kes is null");
        root = put(root, key, val);
    }

    public Node put(Node x, K key, V val) {
        if (x == null)
            return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);
        else if (cmp > 0)
            x.right = put(x.right, key, val);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    private void getKeys(Node x, Set<K> keys) {
        if (x == null)
            return;
        getKeys(x.left, keys);
        keys.add(x.key);
        getKeys(x.right, keys);
    }

    public Set<K> keySet() {
        Set<K> BSTkeys = new HashSet<>();
        getKeys(root, BSTkeys);
        return BSTkeys;
    }


    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    private Node remove(Node x, K key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = remove(x.left, key);
        else if (cmp > 0)
            x.right = remove(x.right, key);
        else {
            if (x.left == null) return x.right;
            if (x.right == null) return x.left;
            Node tmp = x, tmpMin = min(x.right);
            x = tmpMin;
            x.right = remove(tmp.right, tmpMin.key);
            x.left = tmp.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public V remove(K key) {
        if (!containsKey(key))
            return null;
        V toRemove = get(key);
        root = remove(root, key);
        return toRemove;
    }

    public V remove(K key, V value) {
        if (!containsKey(key))
            return null;
        if (!get(key).equals(value))
            return null;
        V toRemove = get(key);
        root = remove(root, key);
        return toRemove;
    }

    public Iterator<K> iterator() {
        return keySet().iterator();
    }


    public void printInOrder(Node x) {
        if (x == null)
            return;
        printInOrder(x.left);
        System.out.print(x.val + " ");
        printInOrder(x.right);
    }
}
