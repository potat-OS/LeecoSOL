public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int maxIndex = nums.length - 1;
        int l1 = maxIndex - 1, l2 = maxIndex;
        while (l1 >= 0 && nums[l1] >= nums[l1 + 1]) {
            l1--;
        }
        if (l1 >= 0) {
            while (l2 >= 0 && nums[l1] >= nums[l2]) {
                l2--;
            }
            swap(nums, l1, l2);
        }
        // if (l1 >= 0) {
        //     int minL2Val = 100;
        //     for (int i = l1 + 1; i <= maxIndex; i++) {
        //         if (nums[i] > nums[l1] && nums[i] < minL2Val) {
        //             minL2Val = nums[i];
        //             l2 = i;
        //         }
        //     }
        //     swap(nums, l1, l2);
        // }
        reverse(nums, l1 + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 3, 3 };
        new NextPermutation().nextPermutation(nums);
        for (int i : nums) {
            System.out.print(i);
        }
    }
}
