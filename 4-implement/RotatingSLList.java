/* SLList, but with additional rotateRight operation. */
public class RotatingSLList<Item> extends SLList<Item> {

    /** To do: Implement RotatingSLList such that code compiles and outputs correct result. */

    /**
     * Rotates list to the right.
     */
    public void rotateRight() {
        Item x = removeLast();
        addFirst(x);
    }

//    @Override
//    public void print() {
//        System.out.println("Rotating");
//    }

    public static void main(String[] args) {
        RotatingSLList<Integer> rsl = new RotatingSLList<>();
        SLList<Integer> s = rsl;
        /* Creates SList: [10, 11, 12, 13] */
        s.addLast(10);
        s.addLast(11);
        s.addLast(12);
        s.addLast(13);

        /* Should be: [13, 10, 11, 12] */
        rsl.rotateRight();
        s.print();
        rsl.print();
    }
} 