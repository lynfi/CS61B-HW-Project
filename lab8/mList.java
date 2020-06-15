public class mList<K, V> {
    private K key;
    private V value;
    private mList<K, V> next;
    private int hashCode;

    public mList(int hashCode, K key, V value, mList<K, V> next) {
        this.hashCode = hashCode;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public int getHashCode() {
        return hashCode;
    }

    public void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public mList<K, V> getNext() {
        return next;
    }

    public void setNext(mList<K, V> next) {
        this.next = next;
    }
}