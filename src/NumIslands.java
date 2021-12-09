class NumIslands {

    private int[] rd = { -1, 0, 1, 0, -1 };
    private int m, n;

    public int numIslands(char[][] grid) {
        int cnt = 0;
        m = grid.length;
        n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) {
                    if (grid[i][j] == '1') {
                        dfs(i, j, grid, vis);
                        cnt++;
                    }
                    vis[i][j] = true;
                }
            }
        }
        return cnt;
    }

    private void dfs(int row, int col, char[][] g, boolean[][] vis) {
        if (!(row >= 0 && row < m && col >= 0 && col < n && g[row][col] == '1')) {
            return;
        }
        if (vis[row][col]) {
            return;
        }
        vis[row][col] = true;
        for (int i = 0; i < rd.length - 1; i++) {
            int r = row + rd[i], c = col + rd[i + 1];
            dfs(r, c, g, vis);
        }
    }

    public static void main(String[] args) {
        // System.out.println(new NumIslands().numIslands(new char[][] {
        // { '1', '1', '0', '0', '0' },
        // { '1', '1', '0', '0', '0' },
        // { '0', '0', '1', '0', '0' },
        // { '0', '0', '0', '1', '1' } }));
        System.out.println(new NumIslands().numIslands(new char[][] { { '1' }, { '1' } }));
    }
}
