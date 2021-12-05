class MyPow {
    public double myPow(double x, int n) {
        return n > 0 ? quickMul(x, n) : 1.0 / quickMul(x, -n);
    }

    // private double quickMul(double x, long n) {
    //     if (n == 0) {
    //         return 1.0;
    //     }
    //     double y = quickMul(x, n / 2);
    //     return n % 2 == 0 ? y * y : y * y * x;
    // }

    private double quickMul(double x, long n) {
        double res = 1.0;
        while (n != 0) {
            if (n % 2 != 0) {
                res *= x;
            }
            x *= x;
            n /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MyPow().myPow(2.0, 10));
    }
}
