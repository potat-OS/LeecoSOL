class FindNthDigit {
    private final long[] range = new long[] { 0L, 9L, 189L, 2889L, 38889L, 488889L, 5888889L, 68888889L, 788888889L,
            8888888889L };

    public int findNthDigit(int n) {
        int len = 9;
        for (int i = 1; i < range.length; i++) {
            if (n <= range[i]) {
                len = i;
                break;
            }
        }
        int low = len - 1;
        long preNum = (long) (Math.pow(10, low));
        long curNum = (n - range[low] - 1) / len;
        long relNum = curNum + preNum;
        int idx = (int) (n - curNum * len - range[low]);
        int ans = Integer.parseInt(String.valueOf(relNum).substring(idx - 1, idx));
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FindNthDigit().findNthDigit(998));
    }
}
