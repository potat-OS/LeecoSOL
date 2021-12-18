class CountBattleships {
    // private int m, n;
    // private final int[] round = { -1, 0, 1, 0, -1 };

    // public int countBattleships(char[][] board) {
    //     int ans = 0;
    //     this.m = board.length;
    //     this.n = board[0].length;
    //     boolean[][] vis = new boolean[m][n];
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (!vis[i][j]) {
    //                 vis[i][j] = true;
    //                 if (board[i][j] == 'X') {
    //                     infect(board, vis, i, j);
    //                     ans++;
    //                 }
    //             }
    //         }
    //     }
    //     return ans;
    // }

    // private void infect(char[][] board, boolean[][] vis, int i, int j) {
    //     for (int idx = 0; idx < 4; idx++) {
    //         int x = i + round[idx], y = j + round[idx + 1];
    //         if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y]) {
    //             vis[x][y] = true;
    //             if (board[x][y] == 'X') {
    //                 infect(board, vis, x, y);
    //             }
    //         }
    //     }
    // }
    public int countBattleships(char[][] board) {
        int ans = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    ans += (j < 1 || board[i][j - 1] == '.') && (i < 1 || board[i - 1][j] == '.') ? 1 : 0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new CountBattleships().countBattleships(new char[][]{
                {'X', 'X', 'X'}
                // , { '.', '.', '.', 'X' }, { '.', '.', '.', 'X' }
        }));
    }
}
