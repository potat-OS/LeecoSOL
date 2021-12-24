import java.util.PriorityQueue;
import java.util.Queue;

class EatenApples {
    public int eatenApples(int[] apples, int[] days) {
        int ans = 0, i = 0;
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        while (true) {
            while (!pq.isEmpty() && pq.peek()[1] <= i) {
                pq.poll();
            }
            if (i < days.length) {
                int appleCnt = apples[i], rottenDay = i + days[i];
                if (appleCnt > 0) {
                    pq.offer(new int[] { appleCnt, rottenDay });
                }
            } else if (pq.isEmpty()) {
                break;
            }
            if (!pq.isEmpty()) {
                int[] tmp = pq.peek();
                tmp[0]--;
                if (tmp[0] > 0) {
                    pq.poll();
                }
                ans++;
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new EatenApples().eatenApples(new int[] { 1, 2, 3, 5, 2 }, new int[] { 3, 2, 1, 4, 2 }));
    }
}
