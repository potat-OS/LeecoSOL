class GetSum {
    public int getSum(int a, int b) {
        if (b == 0) {
            return a;
        }
        int res = a ^ b;
        int c = (a & b) << 1;
        return getSum(res, c);
    }

    public static void main(String[] args) {
        int a = 1, b = 1;
        GetSum getSum = new GetSum();
        System.out.println(getSum.getSum(a, b));

    }
}