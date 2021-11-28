class MissingNumber {

    private int max = 0;
    private int capacity = 0;
    private int maxCapacity = 0;

    public int missingNumber(int[] nums) {
        this.max = nums.length;
        this.maxCapacity = (int) (0.5 * max * (max + 1));
        return addition(nums);

        // return XOR(nums);
    }

    private int addition(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            capacity += nums[i];
        }
        return maxCapacity - capacity;
    }

    // private int XOR(int[] nums) {
    // max = nums.length;
    // for (int i = 0; i < nums.length; i++) {
    // capacity ^= i ^ nums[i];
    // }
    // return max ^ capacity;
    // }

    public static void main(String[] args) {
        int[] nums = { 3, 0, 1 };
        System.out.println(new MissingNumber().missingNumber(nums));
    }
}