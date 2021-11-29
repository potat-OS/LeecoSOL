import java.util.PriorityQueue;
import java.util.Queue;

class KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> arr[x[0]] * arr[y[1]] - arr[y[0]] * arr[x[1]]);
        int maxIdx = arr.length - 1;
        for (int i = 1; i <= maxIdx; i++) {
            pq.offer(new int[] { 0, i });
        }
        for (int i = 1; i < k; i++) {
            int[] frac = pq.poll();
            int x = frac[0], y = frac[1];
            if (++x < y) {
                pq.offer(new int[] { x, y });
            }
        }
        return new int[] { arr[pq.peek()[0]], arr[pq.peek()[1]] };
    }

    public static void main(String[] args) {
        KthSmallestPrimeFraction primeFraction = new KthSmallestPrimeFraction();
        int[] ans = primeFraction.kthSmallestPrimeFraction(new int[] { 1, 2, 3, 5 }, 3);
        System.out.print(ans[0] + ", " + ans[1]);
    }
}
