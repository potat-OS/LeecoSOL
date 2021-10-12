import java.lang.reflect.Constructor;
import java.util.*;

public class Multiply {
    int[] numbs1;
    int[] numbs2;
    List<List<Integer>> list;

    public String multiply(String num1, String num2) {
        numbs1 = new int[num1.length()];
        numbs2 = new int[num2.length()];
        for (int i = 0, j = 0; i < num1.length() || j < num2.length(); i++, j++) {
            if (i < num1.length()) {
                numbs1[i] = Integer.parseInt(num1.substring(i, i + 1));
            }
            if (j < num2.length()) {
                numbs2[j] = Integer.parseInt(num2.substring(i, i + 1));
            }
        }
        if (numbs1.length < numbs2.length) {
            doMultiply(numbs1, numbs2);
        } else {
            doMultiply(numbs2, numbs1);
        }
        return mix();
    }

    public void doMultiply(int[] n1, int[] n2) {

        list = new ArrayList<List<Integer>>();

        for (int i = n1.length - 1; i >= 0; i--) {
            int tmp = 0;
            int multi = 0;
            List<Integer> tmpList = new ArrayList<>();
            for (int j = n2.length - 1; j >= 0; j--) {
                multi = n1[i] * n2[j] + tmp;
                tmp = multi / 10;
                multi = multi % 10;
                tmpList.add(multi);
                if (j == 0) {
                    tmpList.add(tmp);
                }
            }
            list.add(tmpList);
        }
    }

    public String mix() {
        int tmpCount = 0;
        int count = list.get(list.size() - 1).size() + list.size();
        int[] resList = new int[count];
        StringBuilder sBuilder = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            int index = count - tmpCount - 1;
            int tmp = 0;
            int sum = 0;

            for (int j = 0; j < list.get(i).size(); j++) {

                sum = resList[index] + (list.get(i).get(j) + tmp);
                tmp = sum / 10;
                sum = sum % 10;
                resList[index] = sum;
                index--;
            }
            tmpCount++;
        }
        boolean flag = false;
        for (int i = 0; i < resList.length; i++) {
            if (resList[i] != 0 || i == resList.length - 1) {
                flag = true;
            }
            if (flag) {
                sBuilder.append(resList[i]);
            }
        }
        return sBuilder.toString();
    }

    public static void main(String[] args) throws Exception {
        String num1 = "123456789", num2 = "987654321";
        Class<?> clz = Class.forName("Multiply");
        Constructor<?> con = clz.getDeclaredConstructor();
        Multiply multiply = (Multiply) con.newInstance();

        System.out.println(multiply.multiply(num1, num2));
    }
}