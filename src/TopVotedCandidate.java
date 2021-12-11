import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TopVotedCandidate {

    private Map<Integer, Integer> cnt = new HashMap<>();
    private List<Integer> ans = new ArrayList<>();
    private int[] times;
    private int len;

    public TopVotedCandidate(int[] persons, int[] times) {
        cnt.put(-1, -1);
        this.len = times.length;
        this.times = times;
        int p, top = -1;
        for (int i = 0; i < len; i++) {
            p = persons[i];
            cnt.put(p, 1 + cnt.getOrDefault(p, 0));
            top = cnt.get(p) >= cnt.get(top) ? p : top;
            ans.add(top);
        }
    }

    public int q(int t) {
        int lt = 0, rt = len - 1, m;
        while (lt <= rt) {
            m = lt + (rt - lt) / 2;
            if (times[m] < t) {
                lt = m + 1;
            } else if (times[m] > t) {
                rt = m - 1;
            } else {
                return ans.get(m);
            }
        }
        return ans.get(lt - 1);
    }

    public static void main(String[] args) {
        TopVotedCandidate top = new TopVotedCandidate(
                new int[] { 0, 1, 1, 0, 0, 1, 0 },
                new int[] { 0, 5, 10, 15, 20, 25, 30 });
        System.out.println(top.q(3));
        System.out.println(top.q(12));
        System.out.println(top.q(25));
        System.out.println(top.q(15));
        System.out.println(top.q(24));
        System.out.println(top.q(8));
    }
}