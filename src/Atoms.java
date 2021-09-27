import java.util.*;

/**
 * @author Han.Linjue
 */
class Atoms {
    String[] buff;
    String buffLast;
    String dictionary = "abcdefghijklmnopqrstuvwxyz";
    Map<String, Integer> hashMap = new HashMap<>();

    public String countOfAtoms(String formula) {
        buff = formula.split("\\(");
        buff[buff.length - 1] = handleCount(buff[buff.length - 1]);
        String prototype = buff.toString();
        System.out.println(prototype);
        return "";
    }

    // remove parentheses
    public String handleCount(String str) {
        int flag = 0;
        int buffOver = 2;
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                StringBuilder count = new StringBuilder();
                boolean isContinue = true;
                while (isContinue) {
                    if (!Character.isDigit(str.charAt(i))) {
                        isContinue = false;
                    } else {
                        i += 1;
                        count.append(str.charAt(i));
                    }
                }
                flag++;
                if (count.toString() == "") {
                    count.append("1");
                }
                strBuilder = multiplyCount(strBuilder, Integer.parseInt(count.toString()));
                if (flag > 1) {
                    buff[buff.length - buffOver] = multiplyCount(new StringBuilder(buff[buff.length - buffOver]),
                            Integer.parseInt(count.toString())).toString();
                    buffOver++;
                }
            } else {
                strBuilder.append(str.charAt(i));
            }
        }
        return strBuilder.toString();
    }

    // multiply corner mark
    public StringBuilder multiplyCount(StringBuilder input, int inputCount) {
        StringBuilder strBuilder = input;
        StringBuilder addNum = new StringBuilder();

        for (int i = 0; i < strBuilder.length(); i++) {
            if (i + 1 < strBuilder.length()) {
                if (Character.isUpperCase(strBuilder.charAt(i))) {
                    addNum.append(strBuilder.charAt(i));
                    if (Character.isUpperCase(strBuilder.charAt(i + 1))) {
                        addNum.append('1');
                    }
                }
                if (Character.isLowerCase(strBuilder.charAt(i + 1))) {
                    addNum.append(strBuilder.charAt(i));
                    if (Character.isUpperCase(strBuilder.charAt(i + 1))) {
                        addNum.append('1');
                    }
                }
            } else {
                addNum.append(strBuilder.charAt(i));
            }
        }

        for (int i = 0; i < addNum.length(); i++) {
            int j = 0;
            StringBuilder srcCount = new StringBuilder();
            if (Character.isDigit(addNum.charAt(i))) {
                while (true) {
                    if (i + j > addNum.length() - 1) {
                        break;
                    }
                    if (Character.isDigit(addNum.charAt(i + j))) {
                        srcCount.append(addNum.charAt(i + j));
                        j++;
                    } else {
                        break;
                    }
                }
                addNum.replace(i, i + j, String.valueOf(Integer.parseInt(srcCount.toString()) * inputCount));
                i = i + j;
            }
        }
        return addNum;
    }

    public static void main(String[] args) throws Exception {
        Atoms solution = new Atoms();
        String formula = "K4(ON(SO3)3SO3)2Cl";
        System.out.println(solution.countOfAtoms(formula));
    }
}
