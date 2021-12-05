class SuperPow {
    private final int MOD = 1337;

    public int superPow(int a, int[] b) {
        int ans = 1;
        for (int i = b.length - 1; i >= 0; --i) {
            ans = (int) ((long) ans * quickMul(a, b[i]) % MOD);
            a = quickMul(a, 10);
        }
        return ans;
    }

    private int quickMul(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int y = quickMul(x, n / 2);
        return (int) ((n % 2 == 0 ? y * y : y * y * x) % MOD);
    }

    public static void main(String[] args) {
        int a = 2147483647;
        int[] b = new int[] { 2, 0, 0 };
        System.out.println(new SuperPow().superPow(a, b));
    }
}
