class KInversePairs {

    private final int mod = 1000000007;

    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        // 边界条件
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j + 1] = dp[i - 1][j + 1] + dp[i][j] - (j < i - 1 ? 0 : dp[i - 1][j - i + 1]);
                if (dp[i][j + 1] >= mod) {
                    dp[i][j + 1] -= mod;
                } else if (dp[i][j + 1] < 0) {
                    dp[i][j + 1] += mod;
                }
                // dp[i][j + 1] = (dp[i][j + 1] + mod) % mod;
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        int n = 1000, k = 1000;
        System.out.println(new KInversePairs().kInversePairs(n, k));
    }
}
