class FindPoisonedDuration {
    public int findPoisonedDuration(int[] timeSeries, int duration) {

        int ans = 0;
        int interval = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            interval = timeSeries[i] - timeSeries[i - 1];
            ans += interval > duration ? duration : interval;
        }

        return ans + duration;
    }
}
