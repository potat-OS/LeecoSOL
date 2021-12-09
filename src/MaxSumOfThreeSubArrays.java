class MaxSumOfThreeSubArrays {
    public int[] maxSumOfThreeSubArrays(int[] nums, int k) {
        int[] ans = new int[3];
        int sum1 = 0, max1 = 0, idx = 0;
        int sum2 = 0, max12 = 0, idx1 = 0, idx2 = 0;
        int sum3 = 0, max123 = 0;
        for (int i = 2 * k; i < nums.length; i++) {
            sum1 += nums[i - 2 * k];
            sum2 += nums[i - k];
            sum3 += nums[i];
            if (i >= 3 * k - 1) {
                if (sum1 > max1) {
                    max1 = sum1;
                    idx = i - 3 * k + 1;
                }
                if (max1 + sum2 > max12) {
                    max12 = max1 + sum2;
                    idx1 = idx;
                    idx2 = i - 2 * k + 1;
                }
                if (max12 + sum3 > max123) {
                    max123 = max12 + sum3;
                    ans[0] = idx1;
                    ans[1] = idx2;
                    ans[2] = i - k + 1;
                }
                sum1 -= nums[i - 3 * k + 1];
                sum2 -= nums[i - 2 * k + 1];
                sum3 -= nums[i - k + 1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSumOfThreeSubArrays().maxSumOfThreeSubArrays(
                new int[] { 20, 18, 9, 2, 14, 1, 10, 3, 11, 18 }, 3));
    }
}
