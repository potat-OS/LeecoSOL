import java.util.*;

/**
 * @author Han.Linjue
 */
class Ice {

    int flag;
    int count = 0;
    List<Integer> list = new ArrayList<Integer>();

    public int maxIceCream(int[] costs, int coins) {
        if (flag == 1) {
            return Solution1(costs, coins);
        } else {
            return Solution2(costs, coins);
        }
    }

    public int Solution1(int[] costs, int coins) {
        int cost = 0;
        for (int i : costs) {
            if (i < coins) {
                list.add(i);
            }
        }
        Collections.sort(list);

        for (int i : list) {
            cost += i;
            if (cost > coins) {
                break;
            }
            count++;
        }
        return count;
    }

    public int Solution2(int[] costs, int coins) {
        int temp[] = new int[100001];
        for (int cost : costs) {
            temp[cost]++;
        }

        for (int i = 1; i < temp.length - 1; i++) {
            if (coins >= i) {
                int costing = Math.min(temp[i], coins / i);
                count += costing;
                coins -= i * costing;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        Ice solution = new Ice();
        solution.flag = 2;
        int[] costs = { 4, 7, 6, 4, 4, 2, 2, 4, 8, 8 };
        int coins = 41;
        System.out.println(solution.maxIceCream(costs, coins));
    }
}