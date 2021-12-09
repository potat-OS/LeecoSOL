public class IslandPerimeter {
    private final int[] round = { -1, 0, 1, 0, -1 };
    private int m, n;

    public int islandPerimeter(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        int x = 0, y = 0;
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            if (flag) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                    flag = true;
                }
            }
        }
        return recursion(x, y, grid, new boolean[m][n]);
    }

    private int recursion(int row, int col, int[][] g, boolean[][] vis) {
        if (!(row >= 0 && row < m && col >= 0 && col < n && g[row][col] == 1)) {
            return 1;
        }
        if (vis[row][col]) {
            return 0;
        }
        vis[row][col] = true;
        int ans = 0;
        for (int i = 0; i < round.length - 1; i++) {
            int r = row + round[i], c = col + round[i + 1];
            ans += recursion(r, c, g, vis);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new IslandPerimeter().islandPerimeter(new int[][] {
                { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } }));
    }
}
