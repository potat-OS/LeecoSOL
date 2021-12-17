import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class VisiblePoints {

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> cnt = new ArrayList<>();
        int same = 0, posX = location.get(0), posY = location.get(1);
        // 计算并记录弧度
        for (int i = 0; i < points.size(); i++) {
            // 以视线源为原点
            int x = points.get(i).get(0) - posX, y = points.get(i).get(1) - posY;
            // 记录在原点的点位
            if (x == 0 && y == x) {
                same++;
                continue;
            }
            // 已将视线源作为原点，所以直接用三角函数计算弧度表示的 y/x 的反正切
            cnt.add(Math.atan2(y, x));
        }
        Collections.sort(cnt);
        // 由于存在d{pi} + angle > 180°的情况，可以在原数组中将每个元素
        // d{pi} + 360°添加到原数组的后面，这样即可防止反转的问题。
        int cntSize = cnt.size();
        for (int i = 0; i < cntSize; i++) {
            cnt.add(cnt.get(i) + 2 * Math.PI);
        }
        // 滑动窗口
        int rt = 0, max = 0;
        Double toRad = angle * Math.PI / 180;
        cntSize = cnt.size();
        for (int i = 0; i < cntSize; i++) {
            Double rad = cnt.get(i) + toRad;
            while (rt < cntSize && cnt.get(rt) <= rad) {
                rt++;
            }
            max = Math.max(rt - i, max);
        }
        return max + same;
    }

    public static void main(String[] args) {
        List<Integer> tmp1 = new ArrayList<>();
        tmp1.add(0);
        tmp1.add(0);
        List<Integer> tmp2 = new ArrayList<>();
        tmp2.add(0);
        tmp2.add(2);
        // List<Integer> tmp3 = new ArrayList<>();
        // tmp3.add(3);
        // tmp3.add(3);
        // List<Integer> tmp4 = new ArrayList<>();
        // tmp4.add(4);
        // tmp4.add(4);
        List<List<Integer>> points = new ArrayList<>();
        points.add(tmp1);
        points.add(tmp2);
        // points.add(tmp3);
        // points.add(tmp4);
        List<Integer> location = new ArrayList<>();
        location.add(1);
        location.add(1);
        System.out.println(new VisiblePoints().visiblePoints(points, 90, location));
    }
}
