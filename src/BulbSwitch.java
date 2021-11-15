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
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n + 0.5);
    }

    public static void main(String[] args) {
        System.out.println(new BulbSwitch().bulbSwitch(10));
    }
}
