import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class ScheduleCourse {
    public int scheduleCourse(int[][] courses) {
        int cnt = 0;
        Arrays.sort(courses, (x, y) -> x[1] - y[1]);
        Queue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int[] c : courses) {
            if (cnt + c[0] <= c[1]) {
                cnt += c[0];
                pq.offer(c[0]);
            } else if (!pq.isEmpty() && pq.peek() > c[0]) {
                cnt -= pq.poll() - c[0];
                pq.offer(c[0]);
            }
        }
        return pq.size();
    }

    public static void main(String[] args) {
        System.out.println(new ScheduleCourse().scheduleCourse(
                new int[][] { { 5, 5 }, { 4, 6 }, { 2, 6 } }));
    }
}
