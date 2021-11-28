import java.util.Arrays;

class MinMoves {
    public int minMoves(int[] nums) {
        int n = nums.length - 1;
        int ans = 0;
        // 逆向
        // int min = Arrays.stream(nums).min().getAsInt();
        // for (int i = 0; i <= n; i++) {
        //     ans += nums[i] - min;
        // }

        // 正向
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
           ans += (i + 1) * (nums[n - i] - nums[n - 1 - i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 5 };
        System.out.println(new MinMoves().minMoves(nums));
    }
}

