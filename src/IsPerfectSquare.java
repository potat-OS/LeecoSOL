class IsPerfectSquare {

    public boolean isPerfectSquare(int num) {
        boolean ans = false;
        int right = num, mid = 0, left = 1, tmp = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            tmp = num / mid;
            if (tmp > mid) {
                left = mid + 1;
            } else if (tmp > mid) {
                right = mid - 1;
            } else {
                if (num % tmp == 0)
                    ans = true;
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new IsPerfectSquare().isPerfectSquare(16));
    }
}
