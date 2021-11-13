// TODO
public class FindMedianSortedArrays {
    private int[] nums1 = {};
    private int[] nums2 = {};
    private int l1 = 0;
    private int l2 = 0;
    private int len = 0;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.l1 = nums1.length;
        this.l2 = nums2.length;
        this.len = l1 + l2;
        return 0.5 * (findMedian(len / 2, 0, 0) + findMedian((1 + len) / 2, 0, 0));
    }

    private int findMedian(int target, int start1, int start2) {
        int k = target / 2 - 1, i1 = k + start1, i2 = k + start2;
        if (nums1[i1] < nums2[i2]) {
            start1 += k;
        }
        return findMedian(target - k, start1, start2);
    }

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {};
        System.out.println(new FindMedianSortedArrays().findMedianSortedArrays(nums1, nums2));
    }
}
