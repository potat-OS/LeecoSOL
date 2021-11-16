import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class IsRectangleCover {
    public boolean isRectangleCover(int[][] rectangles) {
        Map<String, Integer> map = new HashMap<>();
        long total = 0;
        int minX = 100000, minY = 100000, maxA = 0, maxB = 0;
        int x, y, a, b;
        for (int[] rectangle : rectangles) {
            x = rectangle[0];
            y = rectangle[1];
            a = rectangle[2];
            b = rectangle[3];
            total += (a - x) * (b - y);
            minX = minX > x ? x : minX;
            minY = minY > y ? y : minY;
            maxA = maxA < a ? a : maxA;
            maxB = maxB < b ? b : maxB;
            map.put(x + ":" + y, 1 + map.getOrDefault(x + ":" + y, 0));
            map.put(a + ":" + b, 1 + map.getOrDefault(a + ":" + b, 0));
            map.put(x + ":" + b, 1 + map.getOrDefault(x + ":" + b, 0));
            map.put(a + ":" + y, 1 + map.getOrDefault(a + ":" + y, 0));
        }

        if (total != (maxA - minX) * (maxB - minY) || map.getOrDefault(minX + ":" + minY, 0) != 1
                || map.getOrDefault(maxA + ":" + maxB, 0) != 1 || map.getOrDefault(minX + ":" + maxB, 0) != 1
                || map.getOrDefault(maxA + ":" + minY, 0) != 1) {
            return false;
        }
        map.remove(minX + ":" + minY);
        map.remove(maxA + ":" + maxB);
        map.remove(minX + ":" + maxB);
        map.remove(maxA + ":" + minY);

        for (Entry<String, Integer> item : map.entrySet()) {
            int i = item.getValue();
            if (i != 2 && i != 4) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // int[][] rectangles = { { 1, 1, 3, 3 }, { 3, 1, 4, 2 }, { 3, 2, 4, 4 }, { 1,
        // 3, 2, 4 }, { 2, 3, 3, 4 } };
        // int[][] rectangles2 = { { 0, 0, 1, 1 }, { 0, 1, 3, 2 }, { 1, 0, 2, 2 } };
        int[][] rectangles = { { 1, 1, 3, 3 }, { 3, 1, 4, 2 }, { 3, 2, 4, 4, }, { 1, 3, 2, 4 }, { 2, 3, 3, 4 } };
        System.out.println(new IsRectangleCover().isRectangleCover(rectangles));
    }
}
