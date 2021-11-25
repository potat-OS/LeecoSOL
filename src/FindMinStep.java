import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class FindMinStep {
    Map<String, Integer> map;

    public int findMinStep(String board, String hand) {
        map = new HashMap<>();
        char[] arr = hand.toCharArray();
        Arrays.sort(arr);
        int ans = backTrack(board, new String(arr));
        return ans > 5 ? -1 : ans;
    }

    private int backTrack(String b, String h) {
        int bLen = b.length(), hLen = h.length();
        if (0 == bLen) {
            return 0;
        }
        String key = b + " " + h;
        if (!map.containsKey(key)) {
            int res = 6;
            for (int i = 0; i < hLen; i++) {
                // 第 1 个剪枝条件: 手中当前球的颜色和上一个球的颜色相同
                if (i > 0 && h.charAt(i) == h.charAt(i - 1)) {
                    continue;
                }
                for (int j = 0; j <= bLen; j++) {
                    // 第 2 个剪枝条件: 只在桌上连续相同颜色的球的开头位置插入新球
                    if (j > 0 && b.charAt(j - 1) == h.charAt(i)) {
                        continue;
                    }
                    // 第 3 个剪枝条件: 只在以下两种情况放置新球
                    boolean choose = false;
                    // - 第 1 种情况 : 当前球颜色与后面的球的颜色相同
                    if (j < b.length() && b.charAt(j) == h.charAt(i)) {
                        choose = true;
                    }
                    // - 第 2 种情况 : 当前后颜色相同且与当前颜色不同时候放置球
                    if (j > 0 && j < b.length() && b.charAt(j - 1) == b.charAt(j) && b.charAt(j - 1) != h.charAt(i)) {
                        choose = true;
                    }
                    if (choose) {
                        String newB = remove(b.substring(0, j) + h.charAt(i) + b.substring(j));
                        String newH = h.substring(0, i) + h.substring(i + 1);
                        res = Integer.min(1 + backTrack(newB, newH), res);
                    }
                }
            }
            map.put(key, res);
        }
        return map.get(key);
    }

    private String remove(String balls) {
        int all = balls.length(), start = 0, end = 0;
        while (end < all + 1) {
            if (end < all && balls.charAt(start) == balls.charAt(end)) {
                end++;
            } else {
                if (end - start >= 3) {
                    balls = balls.substring(0, start) + balls.substring(end);
                    break;
                } else {
                    end = ++start;
                }
            }
        }
        return all == balls.length() ? balls.toString() : remove(balls);
    }

    public static void main(String[] args) {
        String board = "BGGRRYY", hand = "BBYRG";
        System.out.println(new FindMinStep().findMinStep(board, hand));
    }
}
