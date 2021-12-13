class IsMatch {
    private char[] sChs, pChs;

    public boolean isMatch(String s, String p) {
        this.sChs = s.toCharArray();
        this.pChs = p.toCharArray();
        int m = sChs.length, n = pChs.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int idxS = i - 1, idxP = j - 1;
                if (pChs[idxP] == '*') {
                    dp[i][j] = dp[i][idxP - 1];
                    if (matches(i, idxP)) {
                        dp[i][j] = dp[i][j] || dp[idxS][j];
                    }
                } else {
                    dp[i][j] = matches(i, j) ? dp[idxS][idxP] : dp[i][j];
                }
            }
        }
        return dp[m][n];
    }

    private boolean matches(int i, int j) {
        return i == 0 ? false : (pChs[j - 1] == '.' ? true : sChs[i - 1] == pChs[j - 1]);
    }

    public static void main(String[] args) {
        System.out.println(new IsMatch().isMatch("aaa", "ab*a*c*a"));
    }
}
