import java.util.HashSet;
import java.util.Set;

class FindMinStep {
    int ans = 6;
    int count = 0;
    Set<String> set;

    public int findMinStep(String board, String hand) {
        set = new HashSet<>();
        backTrack(board, hand);
        return ans == 6 ? -1 : ans;
    }

    private void backTrack(String b, String h) {
        int bLen = b.length(), hLen = h.length();
        int gapCount = 1 + bLen;
        if (0 == bLen) {
            ans = Integer.min(ans, count);
            count = 0;
            return;
        }
        if (0 == hLen) {
            count = 0;
            return;
        }
        count++;
        for (int i = 0; i < gapCount; i++) {
            for (int j = 0; j < hLen; j++) {
                StringBuilder str = new StringBuilder();
                str.append(b, 0, j).append(h.charAt(j));
                if (j != b.length()) {
                    str.append(b.substring(j));
                }
                if (set.add(str.toString())) {
                    remove(str);
                    backTrack(str.toString(), h);
                }
            }
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
