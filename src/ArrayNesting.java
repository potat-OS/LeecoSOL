
class Solution {
    public static int arrayNesting(int[] nums) {
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int k = nums[i];
            do {
                k = nums[k];
                count++;
            } while (k != nums[i]);
            maxLength = Math.max(maxLength, count);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 2, 1 };
        System.out.println(arrayNesting(nums));
    }
}