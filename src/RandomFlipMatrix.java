import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class RandomFlipMatrix {

    Map<Integer, Integer> map = new HashMap<>();
    Random r = new Random();
    int total, n, len;

    public RandomFlipMatrix(int m, int n) {
        this.n = n;
        this.len = m * n;
        this.total = len;
    }

    public int[] flip() {
        int x = r.nextInt(len--);
        int idx = map.getOrDefault(x, x);
        System.out.println(idx);
        map.put(x, map.getOrDefault(len, len));
        return new int[] { idx / n, idx % n };
    }

    public void reset() {
        len = total;
        map.clear();
    }

    public static void main(String[] args) {
        RandomFlipMatrix matrix = new RandomFlipMatrix(3, 3);
        for (int i = 0; i < 9; i++) {
            System.out.println();
            for (int x : matrix.flip()) {
                System.out.print(x);
            }
        }
    }
}