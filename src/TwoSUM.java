import java.util.*;

public class TwoSUM {

    private int[] numbers;
    private int target;

    /**
     *
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    public TwoSUM(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
    }

    public int[] mapSum() {
        // write code here
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.get(target - numbers[i]) != null) {
                return new int[] { map.get(target - numbers[i]) + 1, i + 1 };
            }
            map.put(numbers[i], i);
        }
        return new int[] { -1, -1 };
    }

    public int[] forceSum() {
        // write code here
        int[] res = { -1, -1 };
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (target == numbers[i] + numbers[j]) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] numbers = { 3, 2, 4 };
        int target = 6;
        TwoSUM twoSum = new TwoSUM(numbers, target);
        // int[] res = twoSum.forceSum();
        int[] res = twoSum.mapSum();
        for (int i : res) {
            System.out.print(i);
        }
    }

}