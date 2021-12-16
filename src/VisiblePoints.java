import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class VisiblePoints {

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        final int half = angle / 2, pLen = points.size();
        final int ROUND = 360 - angle;
        final int pos1 = location.get(0), pos2 = location.get(1);
        int ans = 0, in = 0, d = -half;
        Map<Double, Integer> cnt = new HashMap<>();
        for (int i = 0; i < pLen; i++) {
            int x = points.get(i).get(0) - pos1;
            int y = points.get(i).get(1) - pos2;
            if (x == 0 && x == y) {
                in++;
            } else {
                Double degree = Math.atan2(y, x);
                cnt.put(degree, cnt.getOrDefault(degree, 0) + 1);
            }
        }
        while (d < ROUND) {
            Double a1 = (d + half) * Math.PI / 180,
                    a2 = (d - half) * Math.PI / 180;
            if (cnt.containsKey(a1) || cnt.containsKey(a1 + 1)) {
                in += cnt.get(a1);
            } else if (cnt.containsKey(a2) || cnt.containsKey(a2 + 1)) {
                in -= cnt.get(a2);
            }
            ans = Math.max(ans, in);
            d++;
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> tmp1 = new ArrayList<>();
        tmp1.add(2);
        tmp1.add(1);
        List<Integer> tmp2 = new ArrayList<>();
        tmp2.add(2);
        tmp2.add(2);
        List<Integer> tmp3 = new ArrayList<>();
        tmp3.add(3);
        tmp3.add(4);
        List<Integer> tmp4 = new ArrayList<>();
        tmp4.add(1);
        tmp4.add(1);
        List<List<Integer>> points = new ArrayList<>();
        points.add(tmp1);
        points.add(tmp2);
        points.add(tmp3);
        points.add(tmp4);
        List<Integer> location = new ArrayList<>();
        location.add(1);
        location.add(1);

        System.out.println(new VisiblePoints().visiblePoints(points, 90, location));
    }
}
