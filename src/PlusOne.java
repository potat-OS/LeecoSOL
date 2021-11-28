import java.util.Arrays;
import java.util.stream.IntStream;

class PlusOne {
    public int[] plusOne(int[] digits) {
        int tmp = 0;
        int index = digits.length - 1;
        boolean loopFlag = true;
        digits[index] += 1;
        while (loopFlag) {
            digits[index] += tmp;
            if (digits[index] >= 10) {
                tmp = digits[index] / 10;
                digits[index] %= 10;
                if (index == 0) {
                    int[] tmpArr = { tmp };
                    digits = IntStream.concat(Arrays.stream(tmpArr), Arrays.stream(digits)).toArray();
                    loopFlag = false;
                }
                index--;
            } else {
                loopFlag = false;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = { 9, 9, 9 };
        int[] ans = new PlusOne().plusOne(digits);
        System.out.print("{ ");
        for (int i = 0; i < ans.length; i++) {
            if (i == ans.length - 1) {
                System.out.print(ans[i]);
            } else {
                System.out.print(ans[i] + ", ");
            }
        }
        System.out.print(" }");
    }
}
