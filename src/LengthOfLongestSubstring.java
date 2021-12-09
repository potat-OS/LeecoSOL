import java.util.*;

public class LengthOfLongestSubstring {

    // public int lengthOfLongestSubstring(String s) {
    //     boolean flag = true;
    //     int count = 0;
    //     StringBuilder sb = new StringBuilder(s);
    //     Map<Character, Integer> map = new HashMap<>();
    //     for (int i = 0; i < sb.length(); i++) {
    //         if (map.get(sb.charAt(i)) != null) {
    //             i = map.get(sb.charAt(i));
    //             map.clear();
    //             flag = false;
    //         } else {
    //             map.put(sb.charAt(i), i);
    //         }
    //         if (map.size() > count) {
    //             count = map.size();
    //         }
    //     }
    //     if (flag) {
    //         return sb.length();
    //     } else {
    //         return count;
    //     }
    // }

    // public int lengthOfLongestSubstring(String s) {
    //     Set<Character> set = new HashSet<>();
    //     char[] str = s.toCharArray();
    //     int ans = 0, len = str.length;
    //     for (int lt = 0, rt = 0; lt < len; lt++) {
    //         if (lt != 0) {
    //             set.remove(str[lt - 1]);
    //         }
    //         while (rt < len && !set.contains(str[rt])) {
    //             set.add(str[rt++]);
    //         }
    //         ans = Integer.max(ans, rt - lt);
    //     }
    //     return ans;
    // }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] str = s.toCharArray();
        int ans = 0, len = str.length;
        int lt = 0, rt = 0;
        while (rt < len) {
            if (!set.contains(str[rt])) {
                set.add(str[rt++]);
                ans = Integer.max(ans, rt - lt);
            } else {
                set.remove(str[lt++]);
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        String s = "bbb";
        Class<?> clz = Class.forName("LengthOfLongestSubstring");
        System.out.println(
                clz.getMethod("lengthOfLongestSubstring", String.class).invoke(clz.getConstructor().newInstance(), s));
    }
}
