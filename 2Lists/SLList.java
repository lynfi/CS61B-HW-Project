public class SLList {
    public static class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /* The first item is at sentinel.nest */
    private IntNode sentinel; 
    private int size;

    public SLList() {
        sentinel = new IntNode(-1, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(-1, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public SLList(int[] x) {
        sentinel = new IntNode(-1, null);
        IntNode p = sentinel;
        for (int i = 0; i < x.length; i++) {
            p.next = new IntNode(x[i], null);
            size += 1;
            p = p.next;
        }
    }

    /** Adds an item to the front of the list. */
    public void addsentinel(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }    

    /** Retrieves the front item from the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x) {
        IntNode p = sentinel;
        size += 1;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    /* Delete the 1st element*/
    public void delteFirst() {
        IntNode p = sentinel;
        if (p.next == null) {
            return;
        }
        size -= 1;
        p.next = p.next.next;
    }

    /* Print the list. */
    public void pritnAll() {
        IntNode p = sentinel;
        while (p.next != null) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public int size() {
        return size;
    }
    // /** Returns the number of items in the list using recursion. */
    // public int size() {
    //     return size(sentinel);
    // }

    // /** Returns the size of the list starting at IntNode p. */
    // /** It's OK because they have different parameters. */
    // public static int size(IntNode p) {
    //     if (p.next == null) {
    //         return 1;
    //     }
    //     return size(p.next) + 1;
    // }

    public static void main(String[] args) {
       int[] x = {1,2,3};
       SLList L = new SLList(x);
       L.addsentinel(10);
       L.addsentinel(5);
       System.out.println(L.size());
       L.pritnAll();
       L.delteFirst();
       L.pritnAll();
       L.delteFirst();
       L.pritnAll();
    }

}