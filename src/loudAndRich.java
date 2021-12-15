import java.util.HashMap;
import java.util.Map;

class LoudAndRich {
    private Map<Integer, Integer> map = new HashMap<>();
    private int[][] r;
    private int[] q;
    private int[] vis;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int cnt = q.length;
        this.r = richer;
        this.q = quiet;
        this.vis = new int[cnt];
        int[] ans = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            int x = recursion(r[i][0]);
        }

        return ans;
    }

    private int recursion(int cur) {
        int res = Integer.MAX_VALUE;
        res = Math.min(q[cur], res);
        vis[cur] = res;
        for (int i = 0; i < r.length; i++) {
            if (r[i][1] == cur) {
                recursion(r[i][0]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i : new LoudAndRich().loudAndRich(
                new int[][] { { 1, 0 }, { 2, 1 }, { 3, 1 }, { 3, 7 }, { 4, 3 }, { 5, 3 }, { 6, 3 } },
                new int[] { 3, 2, 5, 4, 6, 1, 7, 0 })) {
            System.out.print(i + " ");
        }
    }
}
