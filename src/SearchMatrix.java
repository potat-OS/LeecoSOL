class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (binarySearch(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }

    public boolean binarySearch(int[] matrix, int target) {
        int mid = 0, left = 0, right = matrix.length - 1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (matrix[mid] > target) {
                right = mid - 1;
            } else if (matrix[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
