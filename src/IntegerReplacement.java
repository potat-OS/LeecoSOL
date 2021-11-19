import java.util.HashMap;
import java.util.Map;

class IntegerReplacement {

    // 动态规划 OOM
    // public int integerReplacement(int n) {
    //     int[] dp = new int[n + 2];
    //     dp[1] = 0;
    //     dp[2] = 1;
    //     for (int i = 3; i <= n; i++) {
    //         if ((i & 1) != 0) {
    //             dp[i + 1] = dp[(i + 1) / 2] + 1;
    //             dp[i - 1] = dp[(i - 1) / 2] + 1;
    //             dp[i] = 1 + Integer.min(dp[i + 1], dp[i - 1]);
    //         }
    //     }
    //     return dp[n];
    // }

    // // 递归
    // public int integerReplacement(int n) {
    //     return n == 1 ? 0 : ((n & 1) == 0
    //                         ? 1 + integerReplacement(n / 2)
    //                         : 2 + Integer.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1)));
    // }

    // 记忆化搜索
    Map<Integer, Integer> memo = new HashMap<>();

    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (!memo.containsKey(n)) {
            memo.put(n, (n & 1) == 0 ? 1 + integerReplacement(n / 2)
                    : 2 + Integer.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1)));
        }
        return memo.get(n);
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.println(new IntegerReplacement().integerReplacement(n));
    }
}

