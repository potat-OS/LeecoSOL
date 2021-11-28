import java.util.Random;

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;

class ArrayShuffler {

    // // 调用Collections.shuffle()实现
    // private final int[] nums;
    // private int seed;
    // private int[] shuffled;
    // private List<Integer> list;

    // public ArrayShuffler(int[] nums) {
    //     this.nums = nums;
    //     this.seed = nums.length;
    //     this.shuffled = new int[seed];
    //     this.list = new ArrayList<>();
    //     for (int i = 0; i < seed; i++) {
    //         list.add(i);
    //     }
    // }

    // public int[] reset() {
    //     shuffled = new int[seed];
    //     return nums;
    // }

    // public int[] shuffle() {
    //     List<Integer> tmp = list;
    //     Collections.shuffle(tmp);
    //     for (int i = 0; i < seed; i++) {
    //         shuffled[i] = nums[tmp.get(i)];
    //     }
    //     return shuffled;
    // }

    int[] nums;
    int[] original;
    int len;

    public ArrayShuffler(int[] nums) {
        this.nums = nums;
        this.len = nums.length;
        this.original = new int[len];
        System.arraycopy(nums, 0, original, 0, len);
    }

    public int[] reset() {
        System.arraycopy(original, 0, nums, 0, len);
        return nums;
    }

    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < len; ++i) {
            int j = i + random.nextInt(len - i);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        ArrayShuffler shuffler = new ArrayShuffler(new int[] { 1, 2, 3 });
        shuffler.shuffle();
        shuffler.reset();
        shuffler.shuffle();
    }
}
