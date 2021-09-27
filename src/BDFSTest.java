import java.util.*;

/**
 * @author Han.Linjue
 */
public class BDFSTest {

    int ways,k,n;
    int flag = 0;
    List<List<Integer>> nodes;

    public int numWays(int n, int[][] relation, int k) {
        this.k=k;
        this.n=n;
        if (flag == 0) {
            return BFS(n, relation, k);
        }
        if (flag != 0) {
            nodes = new ArrayList<List<Integer>>();
            for (int i = 0; i < n; i++) {
                nodes.add(new ArrayList<Integer>());                
            }
            for (int[] src : relation) {
                nodes.get(src[0]).add(src[1]);
            }
            DFS(0, 0);
        }
        return ways;
    }

    public int BFS(int n, int[][] relation, int k) {
        int result = 0;
        ArrayList<Integer> from = new ArrayList<Integer>();
        ArrayList<Integer> temp;
        from.add(0);

        for (int i = 0; i < k; i++) {
            temp = new ArrayList<Integer>();
            for (int j : from) {
                temp.add(j);
            }
            from = new ArrayList<Integer>();
            for (int l : temp) {
                for (int[] m : relation) {
                    if (m[0] == l) {
                        from.add(m[1]);
                    }
                }
            }
        }
        for (int tmpRes : from) {
            if (n-1 == tmpRes) {
                result +=1;
            }
        }
        return result;
    }

    public void DFS(int Index, int Step) {
        if (Step == k) {
            if(Index == n-1) {
                ways++;
            }
            return;
        }

        List<Integer> list = nodes.get(Index);
        for (Integer i : list) {
            DFS(i, Step + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BDFSTest solution = new BDFSTest();
        int[][] relation = { { 0, 2 }, { 2, 1 }, { 3, 4 }, { 2, 3 }, { 1, 4 }, { 2, 0 }, { 0, 4 } };
        solution.flag = 1;
        int k = 3;
        int n = 5;
        System.out.println(solution.numWays(n, relation, k));
    }
}