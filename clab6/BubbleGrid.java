public class BubbleGrid {
    private int[][] grid;

    /* Create new BubbleGrid with bubble/space locations specified by grid.
     * Grid is composed of only 1's and 0's, where 1's denote a bubble, and
     * 0's denote a space. */
    public BubbleGrid(int[][] grid) {
        this.grid = grid;
    }

    /* Returns an array whose i-th element is the number of bubbles that
     * fall after the i-th dart is thrown. Assume all elements of darts
     * are unique, valid locations in the grid. Must be non-destructive
     * and have no side-effects to grid. */
    public int[] popBubbles(int[][] darts) {
        int r = grid.length, c = grid[0].length;
        int[] mx = {1, -1, 0, 0};
        int[] my = {0, 0, 1, -1};
        for (int[] dart : darts) {
            if (grid[dart[0]][dart[1]] == 1)
                grid[dart[0]][dart[1]] = 2;
        }
        int roof = r * c;
        UnionFind uf = new UnionFind(roof + 1);
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    int loc = i * c + j;
                    if (i == 0) {
                        uf.union(roof, loc);
                    } else {
                        if (grid[i - 1][j] == 1)
                            uf.union(loc, (i - 1) * c + j);
                        if (j > 0 && grid[i][j - 1] == 1)
                            uf.union(loc, i * c + j - 1);
                    }
                }
            }
        int T = darts.length;
        int[] ans = new int[T];
        for (int t = T - 1; t >= 0; t--) {
            int x = darts[t][0], y = darts[t][1];
            if (grid[x][y] == 0) {
                ans[t] = 0;
                continue;
            }
            int pre = uf.sizeOf(roof);
            int loc = x * c + y;
            for (int i = 0; i < 4; i++) {
                int nx = x + mx[i], ny = y + my[i];
                if (nx >= 0 && nx < r && ny >= 0 && ny < c && grid[nx][ny] == 1) {
                    System.out.println(nx + " " + ny);
                    uf.union(loc, nx * c + ny);
                }
            }
            if (x == 0)
                uf.union(loc, roof);
            grid[x][y] = 1;
            ans[t] = uf.sizeOf(roof) - pre - 1;
            ans[t] = Math.max(ans[t], 0);
        }
        return ans;
    }
}
