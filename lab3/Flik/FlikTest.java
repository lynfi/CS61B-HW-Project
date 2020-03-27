import static org.junit.Assert.*;

import org.junit.Test;

public class FlikTest {
    @Test
    public void testEqual() {
        Integer i = 128;
        Integer j = 128;
        System.out.println(i);
        System.out.println(Flik.isSameNumber(i, j));
        System.out.println(i == j);
        System.out.println(128 == 128);
        System.out.println(i.equals(j));
    }
}
