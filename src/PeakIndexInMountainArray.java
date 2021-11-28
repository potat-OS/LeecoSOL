class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;

        /**
         * for (int i = 0, j = arr.length - 1; i < arr.length && j >= 0; i++, j--) { if
         * (arr[i] - arr[i + 1] > 0) { return i; } if (arr[j] - arr[j - 1] > 0) { return
         * j; } }
         */
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 4, 2 };
        System.out.println(new PeakIndexInMountainArray().peakIndexInMountainArray(arr));
    }
}
