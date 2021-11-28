class GetMoneyAmount {
    public int getMoneyAmount(int n) {
        int minCost = 0;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                minCost = 20100;
                for (int k = i; k < j; k++) {
                    minCost = Integer.min(minCost, k + Integer.max(dp[i][k - 1], dp[k + 1][j]));
                }
                dp[i][j] = minCost;
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        int n = 200;
        System.out.println(new GetMoneyAmount().getMoneyAmount(n));
    }
}
