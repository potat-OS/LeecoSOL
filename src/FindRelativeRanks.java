import java.util.PriorityQueue;
import java.util.Queue;

class FindRelativeRanks {
    // 优先队列
    public String[] findRelativeRanks(int[] score) {
        int len = score.length;
        String[] ans = new String[len];
        String[] topThree = { "Gold Medal", "Silver Medal", "Bronze Medal" };
        Queue<int[]> rank = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        for (int i = 0; i < len; i++) {
            rank.offer(new int[] { i, score[i] });
        }
        for (int i = len; i > 0; i--) {
            int[] r = rank.poll();
            ans[r[0]] = i < 4 ? topThree[i - 1] : String.valueOf(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        for (String rank : new FindRelativeRanks().findRelativeRanks(new int[] { 5, 8, 3, 7, 6 })) {
            System.out.println(rank);
        }
    }
}
