class FindMedianSortedArrays {
    int[] arr1, arr2;
    int len1, len2;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        this.arr1 = nums1;
        this.arr2 = nums2;
        len1 = arr1.length;
        len2 = arr2.length;
        if (len1 == 0) {
            return 0.5 * (arr2[(len2 - 1) / 2] + arr2[len2 / 2]);
        } else if (len2 == 0) {
            return 0.5 * (arr1[(len1 - 1) / 2] + arr1[len1 / 2]);
        } else {
            return 0.5 * (find((len1 + len2 - 1) / 2) + find((len1 + len2) / 2));
        }
    }

    // 找到第k小的数（非二分）
    private int find(int k) {
        int ans = 0, idx = 0, i1 = 0, i2 = 0;
        while (idx <= k) {
            // 边界条件
            if (i1 == len1) {
                return arr2[k - i1];
            }
            if (i2 == len2) {
                return arr1[k - i2];
            }
            // 因为是有序数组可以直接比较
            if (arr1[i1] == arr2[i2]) {
                // 相同时两数组指针同时右移
                ans = arr1[i1];
                i1++; i2++; idx++;
            } else {
                // 值小的数组对应指针右移
                ans = arr1[i1] < arr2[i2] ? arr1[i1++] : arr2[i2++];
            }
            idx++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3, 4 };
        System.out.println(new FindMedianSortedArrays().findMedianSortedArrays(nums1, nums2));
    }
}
