import java.util.Arrays;

class FindRadius {
    public int findRadius(int[] houses, int[] heaters) {
        int ans = 0, len = heaters.length - 1;
        Arrays.sort(heaters);
        for (int i = 0; i < houses.length; i++) {
            int lt = 0, rt = len;
            int min = (int) 1e9;
            if (houses[i] <= heaters[0]) {
                min = heaters[0] - houses[i];
            } else if (houses[i] >= heaters[len]) {
                min = houses[i] - heaters[len];
            } else {
                while (lt < rt) {
                    int mid = (lt + rt) / 2 + lt;
                    if (houses[i] > heaters[mid]) {
                        lt = mid + 1;
                    } else {
                        rt = mid;
                    }
                }
                min = Math.min(heaters[lt] - houses[i], houses[i] - heaters[lt - 1]);
            }
            ans = Math.max(ans, min);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FindRadius().findRadius(new int[] { 1, 2, 3, 4 }, new int[] { 1, 4 }));
    }
}
