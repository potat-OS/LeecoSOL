import java.lang.reflect.Constructor;

public class FindMinMoves {
    int[] machines;
    int[] res;
    int avg;

    public int findMinMoves(int[] machines) {

        int total = 0;
        for (int dress : machines) {
            total += dress;
        }
        if (total % machines.length > 0) {
            return -1;
        }
        // target value
        this.avg = total / machines.length;
        int sum = 0;
        int ans = 0;
        // input array
        this.res = machines;
        for (int i = 0; i < machines.length; i++) {
            res[i] -= avg;
            sum += res[i];
            ans = Math.max(ans, Math.max(Math.abs(sum), res[i]));
        }
        // this.res = new int[machines.length];
        // putDresses(0, machines.length - 1);

        return ans;
    }

    public void putDresses(int start, int end) {
        boolean flagStart = true;
        boolean flagEnd = true;
        while (flagStart || flagEnd) {
            if (start >= end) {
                return;
            }
            if (machines[start] == avg) {
                start++;
            } else {
                flagStart = false;
            }
            if (machines[end] == avg) {
                end--;
            } else {
                flagEnd = false;
            }
        }

        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        int max = 0;
        int maxIndex = 0;
        for (int i = start, j = end; i <= end && j >= start; i++, j--) {
            if (machines[j] <= min) {
                min = machines[j];
                minIndex = j;
            }
            if (machines[i] >= max) {
                max = machines[i];
                maxIndex = i;
            }
        }
        machines[minIndex]++;
        machines[maxIndex]--;
        res[maxIndex]++;
        putDresses(start, end);
    }

    public static void main(String[] args) throws Exception {
        int[] machines = { 4, 0, 0, 4 };
        Class<?> clz = Class.forName("FindMinMoves");
        Constructor<?> constructor = clz.getConstructor();
        FindMinMoves findMinMoves = (FindMinMoves) constructor.newInstance();
        System.out.println(findMinMoves.findMinMoves(machines));
    }

}