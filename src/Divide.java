public class Divide {
    public int divide(int dividend, int divisor) {
        int dd = dividend;
        int dr = divisor;
        if (dd == 0) {
            return 0;
        }
        if (dd == Integer.MIN_VALUE) {
            if (dr == -1) {
                return Integer.MAX_VALUE;
            }
            if (dr == 1) {
                return Integer.MIN_VALUE;
            }
        }
        if (dr == Integer.MIN_VALUE) {
            return dd == Integer.MIN_VALUE ? 1 : 0;
        }

        boolean negative = dd < 0 ^ dr < 0 ? true : false;
        dd = Math.abs(dd);
        dr = Math.abs(dr);
        if (dd < dr) {
            return 0;
        }
        int ans = 1;
        while (true) {
            dd = dd >> 1;
            ans *= 2;
            if (dd <= dr) {
                break;
            }

        }
        return negative ? -ans : ans;
    }

    public static void main(String[] args) throws Exception {
        Class<?> clz = Class.forName("Divide");
        System.out.println(clz.getMethod("divide", new Class[] { int.class, int.class })
                .invoke(clz.getConstructor().newInstance(), 10, 4));
    }
}
