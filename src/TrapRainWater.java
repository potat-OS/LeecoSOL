import java.util.PriorityQueue;
import java.util.Queue;

class TrapRainWater {
    public int trapRainWater(int[][] heightMap) {
        int ans = 0, m = heightMap.length, n = heightMap[0].length;
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> x[2] - y[2]);
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    pq.offer(new int[] { i, j, heightMap[i][j] });
                    vis[i][j] = true;
                }
            }
        }

        int[] round = new int[] { -1, 0, 1, 0, -1 };
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            for (int i = 0; i < 4; i++) {
                int x = poll[0] + round[i], y = poll[1] + round[i + 1];
                if (x > 0 && x < m - 1 && y > 0 && y < n - 1 && !vis[x][y]) {
                    if (poll[2] > heightMap[x][y]) {
                        ans += poll[2] - heightMap[x][y];
                    }
                    pq.offer(new int[] { x, y, Integer.max(poll[2], heightMap[x][y]) });
                    vis[x][y] = true;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] heightMap = new int[][] { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } };
        System.out.println(new TrapRainWater().trapRainWater(heightMap));
    }
}
