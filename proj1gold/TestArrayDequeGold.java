import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class TestArrayDequeGold {

    @Test
    public void testArrayDeque() {
        ArrayDequeSolution<Integer> exp = new ArrayDequeSolution<>();
//        ArrayDeque<Integer> ours = new ArrayDeque<>();
//        LinkedListDeque<Integer> ours = new LinkedListDeque<>();
        StudentArrayDeque<Integer> ours = new StudentArrayDeque<>();
        int N = 100, size = 0;
        for (int i = 0; i < N; i++) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            // remove
            String s;
            if (numberBetweenZeroAndOne < .5 && size > 0) {
                size -= 1;
                Integer rexp, rours;
                if (numberBetweenZeroAndOne < .25) {
                    s = "removeFirst()";
                    rexp = exp.removeFirst();
                    rours = ours.removeFirst();
                    assertEquals("Error in the output of removeFirst", rexp, rours);
                } else {
                    s = "removeLast()";
                    rexp = exp.removeLast();
                    rours = ours.removeLast();
                    assertEquals("Error in the output of removeLast", rexp, rours);
                }
            } else {
                // add
                size += 1;
                numberBetweenZeroAndOne = StdRandom.uniform();
                if (numberBetweenZeroAndOne < .5) {
                    s = "addFirst(" + i + ")";
                    exp.addFirst(i);
                    ours.addFirst(i);
                } else {
                    s = "addLast(" + i + ")";
                    exp.addLast(i);
                    ours.addLast(i);
                }
            }
            System.out.println(s);
            assertEquals("size not equal", exp.size(), ours.size());
            for (int j = 0; j < exp.size(); j++) {
                assertEquals("Error in the list " + "after " + s, exp.get(j), ours.get(j));
            }
        }
    }
}
