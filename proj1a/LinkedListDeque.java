public class LinkedListDeque<T> {
    private class TNode {
        private T item;
        private TNode prev, next;

        private TNode(T x, TNode pr, TNode ne) {
            item = x;
            prev = pr;
            next = ne;
        }

    }

    private int size = 0;
    private TNode sentinel;


    public void addFirst(T item) {
        // add item to the front
        TNode p = new TNode(item, sentinel, sentinel.next);
        sentinel.next.prev = p;
        sentinel.next = p;
        size += 1;
    }

    public void addLast(T item) {
        // add item to the back
        TNode p = new TNode(item, sentinel.prev, sentinel);
        sentinel.prev.next = p;
        sentinel.prev = p;
        size += 1;
    }

    public boolean isEmpty() {
        // return true if deque is empty, false otherwise
        return size != 0;
    }

    public int size() {
        // return the number of items in the deque
        return size;
    }

    public void printDeque() {
        // print items from first to last
        if (size == 0) {
            return;
        }
        TNode p = sentinel.next;
        while (p.next != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println(p.item + " ");
    }

    public T removeFirst() {
        // remove and return the first item
        if (size == 0) {
            return null;
        }
        T first = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        return first;
    }

    public T removeLast() {
        // remove and return the last item
        if (size == 0) {
            return null;
        }
        T last = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        return last;
    }

    public T get(int index) {
        // get the item at index, return null if not exists
        TNode p = sentinel.next;
        while (p != sentinel & index > 0) {
            index -= 1;
            p = p.next;
        }
        if (p == sentinel) {
            return null;
        } else {
            return p.item;
        }
    }

    // TODO
    public T getRecursive(int index) {
        // get the item at index, return null if not exists
        if
        if (index == 0) {

        }
        while (p != sentinel & index > 0) {
            index -= 1;
            p = p.next;
        }
        if (p == sentinel) {
            return null;
        } else {
            return p.item;
        }
    }

    private void init() {
        sentinel = new TNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    /**
     * Create an empty linked list deque
     */
    public LinkedListDeque() {
        init();
    }

    /**
     * Create a deep copy of other
     */
    public LinkedListDeque(LinkedListDeque other) {
        init();
        TNode p = other.sentinel;
        while (p.next != other.sentinel) {
            p = p.next;
            addLast(p.item);
        }
    }


    public static void main(String[] args) {
        LinkedListDeque<Integer> s = new LinkedListDeque<>();
    }
}

