class MaxCount {
    public int maxCount(int m, int n, int[][] ops) {
        int minVertical = m, minHorizon = n;
        for (int[] op : ops) {
            if (minVertical > op[0]) {
                minVertical = op[0];
            }
            if (minHorizon > op[1]) {
                minHorizon = op[1];
            }
        }
        return minHorizon * minVertical;
    }
}
