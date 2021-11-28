// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.Map;
// import java.util.Set;

class MaxProduct {

    // // 朴素的做法 1180ms 10%
    // public int maxProduct(String[] words) {
    //     this.words = words;
    //     int ans = 0, len1 = 0, len2 = 0;
    //     String m1, m2;
    //     for (int i = 0; i < words.length - 1; i++) {
    //         m1 = words[i];
    //         len1 = m1.length();
    //         for (int j = i + 1; j < words.length; j++) {
    //             m2 = words[j];
    //             len2 = m2.length();
    //             ans = isDiff(m1, m2) ? Math.max(ans, len1 * len2) : ans;
    //         }
    //     }
    //     return ans;
    // }

    // // 比较每个字符判断是否有公共字母
    // private boolean isDiff(String m1, String m2) {
    //     Set<Character> set = new HashSet<>();
    //     for (int i = 0; i < m1.length(); i++) {
    //         set.add(m1.charAt(i));
    //     }
    //     for (int i = 0; i < m2.length(); i++) {
    //         if (set.contains(m2.charAt(i))) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // 位运算6ms 100%
    public int maxProduct(String[] words) {
        // Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        // 预处理：位运算得每个单词的掩码
        int[] masks = new int[words.length];
        int[] lens = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            int len = w.length();
            lens[i] = len;
            for (int j = 0; j < len; j++) {
                masks[i] |= 1 << w.charAt(j) - 'a';
            }
            // if (len > map.getOrDefault(masks[i], 0)) {
            //     map.put(masks[i], len);
            // }
        }
        for (int i = 0; i < masks.length - 1; i++) {
            for (int j = i + 1; j < masks.length; j++) {
                ans = (masks[i] & masks[j]) == 0 ? Math.max(ans, lens[i] * lens[j]) : ans;
            }
        }
        // int len1 = 0, len2 = 0;
        // Set<Integer> maskSet = map.keySet();
        // for (int m1 : maskSet) {
        //     len1 = map.get(m1);
        //     for (int m2 : maskSet) {
        //         len2 = map.get(m2);
        //         // 与运算比较两字串掩码是否有相同位以判断是否有公共字母
        //         ans = (m1 & m2) == 0 ? Math.max(ans, len1 * len2) : ans;
        //     }
        // }
        return ans;
    }

    // // 位运算6ms 100%, 官解优化慢了应该是map遍历不能控制下标增加了循环次数
    // public int maxProduct(String[] words) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     int ans = 0;
    //     // 预处理：位运算得每个单词的掩码
    //     int[] masks = new int[words.length];
    //     // int[] lens = new int[words.length];
    //     for (int i = 0; i < words.length; i++) {
    //         String w = words[i];
    //         int len = w.length();
    //         // lens[i] = len;
    //         for (int j = 0; j < len; j++) {
    //             masks[i] |= 1 << w.charAt(j) - 'a';
    //         }
    //         if (len > map.getOrDefault(masks[i], 0)) {
    //             map.put(masks[i], len);
    //         }
    //     }
    //     // for (int i = 0; i < masks.length - 1; i++) {
    //     //     for (int j = i + 1; j < masks.length; j++) {
    //     //         ans = (masks[i] & masks[j]) == 0 ? Math.max(ans, lens[i] * lens[j]) : ans;
    //     //     }
    //     // }
    //     int len1 = 0, len2 = 0;
    //     Set<Integer> maskSet1 = new HashSet<>(map.keySet());
    //     Set<Integer> maskSet2;
    //     for (int m1 : maskSet1) {
    //         len1 = map.get(m1);
    //         map.remove(m1);
    //         maskSet2 = map.keySet();
    //         for (int m2 : maskSet2) {
    //             len2 = map.get(m2);
    //             // 与运算比较两字串掩码是否有相同位以判断是否有公共字母
    //             ans = (m1 & m2) == 0 ? Math.max(ans, len1 * len2) : ans;
    //         }
    //     }
    //     return ans;
    // }

    public static void main(String[] args) {
        String[] words = { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" };
        System.out.println(new MaxProduct().maxProduct(words));
    }
}
