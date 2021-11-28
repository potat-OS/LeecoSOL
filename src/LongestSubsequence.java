import java.util.HashMap;
import java.util.Map;

class LongestSubsequence {

    public int longestSubsequence(int[] arr, int difference) {
        int ans = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            map.put(val, map.getOrDefault(val - difference, 0) + 1);
            ans = Integer.max(ans, map.get(val));
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        int[] arr = { 1, 2, 3, 4 };
        int difference = 1;
        Class<?> clz = Class.forName("LongestSubsequence");
        System.out.println(clz.getMethod("longestSubsequence", int[].class, int.class)
                .invoke(clz.getConstructor().newInstance(), arr, difference));
    }
}
