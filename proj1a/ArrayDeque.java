import java.util.Objects;

public class ArrayDeque<T> {
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
        System.arraycopy(items, 0, other, 0, length);
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


    public void addLast(T x) {
        // Inserts X into the back of the list
        if (size == length) {
            reSize(length * 2);
        }
        items[nextLast] = x;
        nextLast = plusOne(nextLast, length);
        size += 1;
    }


    public void addFirst(T x) {
        // Inserts X into the front of the list
        if (size == length) {
            reSize(length * 2);
        }
        items[nextFirst] = x;
        nextFirst = minusOne(nextFirst, length);
        size = size + 1;
    }


    public T get(int i) {
        // Gets the ith item in the list (0 is the front).
        if (i >= size || i < 0) {
            return null;
        }
        return items[(nextFirst + 1 + i) % length];
    }

    public int size() {
        // Returns the number of items in the list.
        return size;
    }


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
        ArrayDeque<Integer> a = new ArrayDeque<Integer>();
        a.addLast(1);
        a.printDeque();
        a.addLast(2);
        a.printDeque();
        a.addFirst(0);
        a.printDeque();
        for (int i = 0; i < 1000000; i++) {
            a.addFirst(i);
        }
        System.out.println(a.get(0));
        for (int i = 0; i < 1000000; i++) {
            a.removeFirst();
        }
        System.out.println(a.size);
        System.out.println(a.length);
        System.out.print(a.get(0));

    }

}