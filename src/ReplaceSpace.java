/**
 * @author Han.Linjue
 */
class ReplaceSpace {
    int flag = 0;

    public String replaceSpace(String s) {
        if (flag == 1) {
            return solution1(s);
        } else {
            return solution2(s);
        }
    }

    public String solution1(String s) {
        return s.replace(" ", "%20");
    }

    public String solution2(String s) {
        StringBuilder strs = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                strs.append("%20");
            } else {
                strs.append(s.charAt(i));
            }
        }
        return strs.toString();
    }

    public static void main(String[] args) throws Exception {
        ReplaceSpace solution = new ReplaceSpace();
        solution.flag = 2;
        String s = "We are happy.";
        System.out.println(solution.replaceSpace(s));
    }
}