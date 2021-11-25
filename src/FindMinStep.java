import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class FindMinStep {
    int ans = 5;
    Map<String, Integer> map;

    public int findMinStep(String board, String hand) {
        map = new HashMap<>();
        char[] arr = hand.toCharArray();
        Arrays.sort(arr);
        backTrack(board, new String(arr));
        return ans >= 5 ? -1 : ans;
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
                for (int j = 0; j <= bLen; j++) {
                    StringBuilder str = new StringBuilder();
                    str.append(b, 0, j).append(h.charAt(j));
                    if (j != b.length()) {
                        str.append(b.substring(j));
                    }
                    remove(str);
                    res = Integer.min(backTrack(str.toString(), h), res);
                }
            }
            map.put(key, res);
        }
    }

    private StringBuilder remove(StringBuilder balls) {
        int all = balls.length(), start = 0, end = 0;
        while (end < all + 1) {
            if (end < all && balls.charAt(start) == balls.charAt(end)) {
                end++;
            } else {
                if (end - start >= 3) {
                    balls.delete(start, end);
                    break;
                } else {
                    end = ++start;
                }
            }
        }
        return all == balls.length() ? balls : remove(balls);
    }

    public static void main(String[] args) {
        String board = "WWRRBBWW", hand = "WRBRW";
        System.out.println(new FindMinStep().findMinStep(board, hand));
    }
}
