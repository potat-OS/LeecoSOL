public class FindJudge {
    public int findJudge(int n, int[][] trust) {
        int[] weight = new int[n + 1];
        for (int i = 0; i < trust.length; i++) {
            weight[trust[i][0]]--;
            weight[trust[i][1]]++;
        }
        int ans = -1;
        for (int i = 1; i < weight.length; i++) {
            if (weight[i] == n - 1) {
                return ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FindJudge().findJudge(1, new int[][] {}));
    }
}
