public class ArrayDeque {
    private int[] items;
    private int size, nextFirst, nextLast;

    /**
     * Creates an empty list.
     */
    public ArrayDeque() {
        items = new int[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public ArrayDeque(ArrayDeque other) {
        size = other.size;
        items = new int[size];
        System.arraycopy(items, 0, other, 0, size);
    }

    /**
     * Inserts X into the back of the list.
     */
    public void addLast(int x) {
        if (size == items.length) {
            int[] a = new int[size * 2];
            int i = (nextFirst + 1) % size;
            nextFirst = size - 1;
            nextLast = size;
            for (int j = 0; j < size; j++) {
                a[nextLast] = items[i];
                nextLast = (nextLast + 1) % (size * 2);
            }
            items = a;
        }
        items[size] = x;
        size = size + 1;
    }

    /**
     * Returns the item from the back of the list.
     */
    public int getLast() {
        return items[size - 1];
    }

    /**
     * Gets the ith item in the list (0 is the front).
     */
    public int get(int i) {
        return items[i];
    }

    /**
     * Returns the number of items in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Deletes item from back of the list and
     * returns deleted item.
     */
    public int removeLast() {
        int x = getLast();
        size = size - 1;
        if (items.length > 16 && size < items.length * .25) {
            int[] a = new int[items.length / 2];
            System.arraycopy(items, 0, a, 0, size);
            items = a;
        }
        return x;
    }

    public void main() {

    }
}