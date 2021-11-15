public class BulbSwitch {
    // 击败5%
    // public int bulbSwitch(int n) {
    // int ans = 0;
    // for (int i = 1; i <= n; i++) {
    // ans += havePower(i) ? 1 : 0;
    // }
    // return ans;
    // }
    // private boolean havePower(int n) {
    // int sqrt = (int) Math.sqrt(n);
    // return sqrt * sqrt == n;
    // }

    // public int bulbSwitch(int n) {
    // return (int) Q_sqrt(n + 0.5F);
    // }
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n + 0.5F);
    }

    // private float Q_sqrt(float n) {
    // float nHalf = 0.5F * n;
    // float res = n;
    // int i = (int) res;
    // i = 0x5f375a86 - (i >> 1);
    // res = (float) i;
    // res = res * (1.5F - nHalf * res * res);
    // return res;
    // }

    public static void main(String[] args) {
        int n = 4;
        BulbSwitch bulbSwitch = new BulbSwitch();
        int ans = bulbSwitch.bulbSwitch(n);
        long start = System.currentTimeMillis();
        for (long i = 0; i < 1000000000; i++) {
            bulbSwitch.bulbSwitch(n);
        }
        long end = System.currentTimeMillis();
        System.out.println(ans + ":" + (end - start));
    }
}
