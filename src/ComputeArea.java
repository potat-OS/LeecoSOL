import java.lang.reflect.Constructor;

public class ComputeArea {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        if (ax1 < bx2 && ax2 > bx1 && ay1 < by2 && ay2 > by1) {
            return Math.abs(ax2 - ax1) * Math.abs(ay2 - ay1) + Math.abs(bx2 - bx1) * Math.abs(by2 - by1)
                    - intersectLength(ax1, ax2, bx1, bx2) * intersectLength(ay1, ay2, by1, by2);
        } else {
            return Math.abs(ax2 - ax1) * Math.abs(ay2 - ay1) + Math.abs(bx2 - bx1) * Math.abs(by2 - by1);
        }
    }

    public int intersectLength(int a1, int a2, int b1, int b2) {
        // totally overlap
        if (a1 == b1 && a2 == b2) {
            return Math.abs(a2 - a1);
        }
        // left overlap
        if (a1 == b1) {
            if (a2 > b2) {
                return Math.abs(b2 - b1);
            } else {
                return Math.abs(a2 - a1);
            }
        }
        // right overlap
        if (a2 == b2) {
            if (a1 > b1) {
                return Math.abs(a2 - a1);
            } else {
                return Math.abs(b2 - b1);
            }
        }

        // left intersection
        if (a1 > b1) {
            if (a2 < b2) {
                return a2 - a1;
            } else {
                return Math.abs(b2 - a1);
            }
        } else {
            if (a2 > b2) {
                return b2 - b1;
            } else {
                return Math.abs(a2 - b1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int ax1 = 0, ay1 = 0, ax2 = 0, ay2 = 0, bx1 = -1, by1 = -1, bx2 = 1, by2 = 1;
        Class<?> clz = Class.forName("ComputeArea");
        Constructor<?> constructor = clz.getConstructor();
        ComputeArea compute = (ComputeArea) constructor.newInstance();
        System.out.println(compute.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
    }
}
