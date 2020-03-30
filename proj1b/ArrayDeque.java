public class ArrayDeque<T> implements Deque<T> {

    private T[] items;
    private int size, nextFirst, nextLast, length;

    public ArrayDeque() {
        // Creates an empty list.
        length = 8;
        items = (T[]) new Object[length];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }


    public ArrayDeque(ArrayDeque other) {
        // Deep copy of other
        size = other.size;
        length = other.length;
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;
        items = (T[]) new Object[length];
        System.arraycopy(other.items, 0, items, 0, length);
    }


    public static int plusOne(int index, int length) {
        // return the index after plus 1
        return (index + 1) % length;
    }


    public static int minusOne(int index, int length) {
        // return the index after minus 1
        return (index - 1 + length) % length;
    }


    public void reSize(int newLength) {
        // resize the array
        T[] a = (T[]) new Object[newLength];
        int i = plusOne(nextFirst, length);
        nextFirst = 0;
        nextLast = 1;
        for (int j = 0; j < size; j++) {
            a[nextLast] = items[i];
            nextLast = plusOne(nextLast, newLength);
            i = plusOne(i, length);
        }
        items = a;
        length = newLength;
    }

    @Override
    public void addLast(T x) {
        // Inserts X into the back of the list
        if (size == length) {
            reSize(length * 2);
        }
        items[nextLast] = x;
        nextLast = plusOne(nextLast, length);
        size += 1;
    }

    @Override
    public void addFirst(T x) {
        // Inserts X into the front of the list
        if (size == length) {
            reSize(length * 2);
        }
        items[nextFirst] = x;
        nextFirst = minusOne(nextFirst, length);
        size = size + 1;
    }

    @Override
    public T get(int i) {
        // Gets the ith item in the list (0 is the front).
        if (i >= size || i < 0) {
            return null;
        }
        return items[(nextFirst + 1 + i) % length];
    }

    @Override
    public int size() {
        // Returns the number of items in the list.
        return size;
    }

    @Override
    public T removeLast() {
        // remove and return the last element
        if (size == 0) {
            return null;
        }
        nextLast = minusOne(nextLast, length);
        T x = items[nextLast];
        size -= 1;
        if (length > 16 && size < length / 4) {
            reSize(length / 2);
        }
        return x;
    }

    @Override
    public T removeFirst() {
        // remove and return the first element
        if (size == 0) {
            return null;
        }
        nextFirst = plusOne(nextFirst, length);
        T x = items[nextFirst];
        size -= 1;
        if (length > 16 && size < length * .25) {
            reSize(length / 2);
        }
        return x;
    }

    @Override
    public void printDeque() {
        // print all elements
        int j = plusOne(nextFirst, length);
        for (int i = 0; i < size; i++) {
            System.out.print(items[j] + " ");
            j = plusOne(j, length);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ArrayDeque<Integer> a = new ArrayDeque();
//        a.addLast(1);
//        a.printDeque();
//        a.addLast(2);
//        a.printDeque();
//        a.addFirst(0);
//        a.printDeque();
        for (int i = 0; i < 100; i++) {
            a.addFirst(i);
        }
        System.out.println(a.get(0));
        ArrayDeque<Integer> b = new ArrayDeque(a);
        for (int i = 0; i < 100; i++) {
            a.removeFirst();
        }
        System.out.println(a.size);
        System.out.println(a.length);
        System.out.println(a.get(0));
        System.out.println(b.size);
        System.out.println(b.length);
        System.out.print(b.get(0));

    }
}
