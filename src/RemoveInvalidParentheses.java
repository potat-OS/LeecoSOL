import java.util.ArrayList;
import java.util.List;

class RemoveInvalidParentheses {

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
        backTrack(new StringBuilder(sArr.toString()), left, right);
        return null;
    }

    private void backTrack(StringBuilder expr, int left, int right) {
        if (left == 0 && right == 0) {

        }
        for (int i = 0; i < expr.length(); i++) {

            if (left > 0 && expr.charAt(i) == '(') {
                expr.delete(i, i + 1);
                backTrack(expr, left - 1, right);
            }
            if (right > 0 && expr.charAt(i) == ')') {
                backTrack(expr, left, right - 1);
            }
        }

    }

    public static void main(String[] args) {
        String s = "()))((()";
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses(s));
    }
}
