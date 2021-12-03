import java.util.PriorityQueue;
import java.util.Queue;

class LargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>((x, y) -> x - y);
        int negCnt = 0;
        for (int i : nums) {
            negCnt += i < 0 ? 1 : 0;
            pq.offer(i);
        }
        int ans = 0, over = k - negCnt;
        if (over > 0) {
            while (negCnt > 0) {
                int i = pq.poll();
                pq.offer(-i);
                negCnt--;
            }
            int tmp = pq.poll();
            ans += (over & 1) == 0 ? tmp : -tmp;
            while (!pq.isEmpty()) {
                ans += pq.poll();
            }
        } else {
            while (!pq.isEmpty()) {
                int i = pq.poll();
                ans += k-- > 0 ? -i : i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                new LargestSumAfterKNegations().largestSumAfterKNegations(new int[] { 2, -3, -1, 5, -4 }, 2));
    }
}
