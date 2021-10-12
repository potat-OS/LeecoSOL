public class ArrangeCoins {
    public int arrangeCoins(int n) {

        return (int) (-1 + Math.sqrt(1 + 8 * (long) n)) / 2;

    }

    public static void main(String[] args) {

        ArrangeCoins arrangeCoins = new ArrangeCoins();
        System.out.println(arrangeCoins.arrangeCoins(8));
    }
}
