import java.util.*;

class SummaryRanges {
    private int[] container;
    private int index;
    private int length;

    //?造体初始化
    public SummaryRanges() {
        container = new int[] {};
        index = 0;
        length = 0;
    }

    //?容操作
    public int[] grow() {

        int oldCapacity = container.length == 0 ? 10 : container.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - oldCapacity + 1 <= 0) {
            newCapacity = oldCapacity + 1;
        }
        return Arrays.copyOf(container, newCapacity);
    }

    //追加操作
    public void addNum(int val) {
        if (index == container.length) {
            container = grow();
        }
        container[index] = val;
        index++;
        length++;
    }

    //分????始位置?束位置以及??数的?度，包括相等情况
    public int[][] getIntervals() {

        Arrays.sort(container, 0, length);
        List<int[]> tempList = new ArrayList<>();
        int[][] resArr;
        int start = 0, end = 0, tmp = 0;
        while (start < length) {
            for (int i = start; i < length - 1; i++) {
                if (container[i + 1] - container[i] == 1 || container[i + 1] - container[i] == 0) {
                    tmp++;
                } else {
                    break;
                }
            }
            end = start + tmp;
            tempList.add(new int[] { container[start], container[end] });
            start = end + 1;
            tmp = 0;
        }

        resArr = new int[tempList.size()][2];
        for (int i = 0; i < tempList.size(); i++) {
            resArr[i] = tempList.get(i);
        }

        return resArr;
    }

    public static void printRes(int[][] res) {
        System.out.print("{ ");
        for (int j = 0; j < res.length; j++) {
            System.out.print("{ ");
            for (int k = 0; k < res[j].length; k++) {
                System.out.print(res[j].length - 1 == k ? res[j][k] + "" : res[j][k] + ", ");
            }
            System.out.print(j == res.length - 1 ? " }" : " }, ");
        }
        System.out.println(" }");
    }

    public static void main(String[] args) {
        SummaryRanges obj = new SummaryRanges();
        obj.addNum(6);
        printRes(obj.getIntervals());
        obj.addNum(6);
        printRes(obj.getIntervals());
        obj.addNum(0);
        printRes(obj.getIntervals());
        obj.addNum(4);
        printRes(obj.getIntervals());
        obj.addNum(8);
        printRes(obj.getIntervals());
    }
}