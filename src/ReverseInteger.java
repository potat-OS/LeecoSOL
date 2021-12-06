class ReverseInteger {

    public int reverse(int x) {
        int ans = 0, pre = 0;
        while (x != 0) {
            pre = ans;
            ans = ans * 10 + x % 10;
            x /= 10;
            if (ans / 10 != pre) {
                return 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(-2147483648));
    }
}
