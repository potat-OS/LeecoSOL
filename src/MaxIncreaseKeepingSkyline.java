class MaxIncreaseKeepingSkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m, n, ans = 0;
        int[] vertical = new int[m = grid.length];
        int[] horizon = new int[n = grid[0].length];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                horizon[j] = grid[i][j] > horizon[j] ? grid[i][j] : horizon[j];
                vertical[i] = grid[i][j] > vertical[i] ? grid[i][j] : vertical[i];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = horizon[j] < vertical[i] ? horizon[j] : vertical[i];
                ans += min > grid[i][j] ? min - grid[i][j] : 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaxIncreaseKeepingSkyline()
                .maxIncreaseKeepingSkyline(new int[][] {
                        { 3, 0, 8, 4 }, { 2, 4, 5, 7 }, { 9, 2, 6, 3 }, { 0, 3, 1, 0 } }));
    }
}
