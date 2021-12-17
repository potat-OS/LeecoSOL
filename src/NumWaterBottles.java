public class NumWaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drink = numBottles, empty = drink;
        while (empty >= numExchange) {
            int less = empty % numExchange;
            drink += (empty /= numExchange);
            empty += less;
        }
        return drink;
    }

    public static void main(String[] args) {
        System.out.println(new NumWaterBottles().numWaterBottles(15, 4));
    }
}
