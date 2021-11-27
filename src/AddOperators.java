import java.util.LinkedList;
import java.util.List;

class AddOperators {

    List<String> ans;
    String num;
    int t;
    int n;

    public List<String> addOperators(String num, int target) {
        this.num = num;
        this.t = target;
        this.n = num.length();
        this.ans = new LinkedList<>();
        StringBuilder expr = new StringBuilder();
        backTrack(expr, 0, 0, 0);
        return ans;

    }

    private void backTrack(StringBuilder expr, int i, long res, long before) {
        if (i == n) {
            if (res == t) {
                ans.add(expr.toString());
            }
            return;
        }
        int signIndex = expr.length();
        if (i > 0) {
            expr.append(0);
        }
        long val = 0;
        for (int j = i; j < n && (j == i || num.charAt(i) != '0'); j++) {
            val = val * 10 + num.charAt(j) - '0';
            expr.append(num.charAt(j));
            if (i == 0) {
                backTrack(expr, j + 1, val, val);
            } else {
                expr.setCharAt(signIndex, '+');
                backTrack(expr, j + 1, res + val, val);
                expr.setCharAt(signIndex, '-');
                backTrack(expr, j + 1, res - val, -val);
                expr.setCharAt(signIndex, '*');
                backTrack(expr, j + 1, res - before + before * val, before * val);
            }
        }
        expr.setLength(signIndex);
    }

    public static void main(String[] args) {
        System.out.println(new AddOperators().addOperators("2032", 8));
    }
}
