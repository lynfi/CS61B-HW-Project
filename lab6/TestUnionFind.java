import org.junit.Test;

import static org.junit.Assert.*;

public class TestUnionFind {

    UnionFind uf = new UnionFind(10);

    @Test
    public void testBasic() {
        uf.union(0, 1);
        uf.union(2, 3);
        uf.union(1, 2);
        assertEquals(4, uf.sizeOf(0));
        assertEquals(4, uf.sizeOf(1));
        assertEquals(4, uf.sizeOf(2));
        assertEquals(4, uf.sizeOf(3));
        assertTrue(uf.connected(0, 2));
        assertFalse(uf.connected(1, 5));

        uf.union(4, 5);
        uf.union(5, 6);
        uf.union(4, 0);
        for (int i = 0; i < 7; i++)
            uf.find(i);
        int root = -1;
        for (int i = 0; i < 7; i++) {
            if (uf.parent(i) < 0) {
                continue;
            } else {
                if (root < 0) root = uf.parent(i);
            }
            assertEquals(uf.parent(i), root); // Path-compression
            assertEquals(7, uf.sizeOf(i));
        }
        assertTrue(uf.connected(1, 4));
        assertFalse(uf.connected(1, 8));
    }

}