public class BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        int sLen = s.length();
        int[] sArr = new int[26];
        if (s.equals(goal)) {
            for (int i = 0; i < sLen; i++) {
                int cur = s.charAt(i) - 97;
                if (sArr[cur] > 0) {
                    return true;
                } else {
                    sArr[cur]++;
                }
            }
            return false;
        } else {
            int left = -1, right = -1;
            if (sLen != goal.length()) {
                return false;
            } else {
                for (int i = 0; i < sLen; i++) {
                    if (s.charAt(i) != goal.charAt(i)) {
                        if (left == -1) {
                            left = i;
                        } else if (right == -1) {
                            right = i;
                        } else {
                            return false;
                        }
                    }
                }
                return right != -1 && s.charAt(left) == goal.charAt(right)
                                   && s.charAt(right) == goal.charAt(left)
                                   ? true : false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new BuddyStrings().buddyStrings("abac", "abad"));
    }
}
