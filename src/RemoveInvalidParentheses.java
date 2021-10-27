import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveInvalidParentheses {

    List<String> ans = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        char[] sArr = s.toCharArray();
        int left = 0;
        int right = 0;

        for (int i = 0; i < sArr.length; i++) {
            switch (sArr[i]) {
            case '(':
                left++;
                break;
            case ')':
                if (left != 0) {
                    left--;
                } else {
                    right++;
                }
                break;
            default:
                break;
            }
        }
        backTrack(sArr, left, right);
        return null;
    }

    private void backTrack(char[] sArr, int left, int right) {
        if (left == 0 && right == 0) {

        }
        for (int i = 0; i < sArr.length; i++) {

            if (left > 0 && sArr[i] == '(') {
                sArr[i] = '/';
                backTrack(sArr, left - 1, right);
            }
            if (right > 0 && sArr[i] == ')') {
                backTrack(sArr, left, right - 1);
            }
        }

    }

    public static void main(String[] args) {
        String s = "()))((()";
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses(s));
    }
}
