import java.util.ArrayList;
import java.util.List;

class ColorBorder {
    private final int[] round = { -1, 0, 1, 0, -1 };
    private List<int[]> ls = new ArrayList<>();
    private int m, n, tar;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        this.tar = grid[row][col];
        dfs(row, col, grid, new boolean[m = grid.length][n = grid[0].length]);
        for (int i = 0; i < ls.size(); i++) {
            int[] tmp = ls.get(i);
            grid[tmp[0]][tmp[1]] = color;
        }
        return grid;
    }

    private void dfs(int row, int col, int[][] g, boolean[][] vis) {
        boolean isBorder = false;
        for (int i = 0; i < round.length - 1; i++) {
            int r = row + round[i], c = col + round[i + 1];
            if (!(r >= 0 && r < m && c >= 0 && c < n && g[r][c] == tar)) {
                isBorder = true;
            } else if (!vis[r][c]) {
                vis[r][c] = true;
                dfs(r, c, g, vis);
            }
        }
        if (isBorder) {
            ls.add(new int[] { row, col });
        }
    }

    public static void main(String[] args) {
        for (int[] arr : new ColorBorder().colorBorder(
                new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } }, 1, 1, 2)) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
