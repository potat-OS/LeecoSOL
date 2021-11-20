import java.util.HashMap;
import java.util.Map;

class FindLHS {
    public int findLHS(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 1 + map.getOrDefault(nums[i], 0));
        }
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                ans = Math.max(ans, map.get(key) + map.get(key + 1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1 };
        System.out.println(new FindLHS().findLHS(nums));
    }
}
