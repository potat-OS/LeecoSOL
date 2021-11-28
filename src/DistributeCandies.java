import java.util.Arrays;

class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        return Arrays.stream(candyType).distinct().count() > (candyType.length / 2) ? candyType.length / 2
                : (int) Arrays.stream(candyType).distinct().count();
    }

    public static void main(String[] args) {
        int[] candyType = { 1, 2, 3, 4 };
        System.out.println(new DistributeCandies().distributeCandies(candyType));
    }
}
