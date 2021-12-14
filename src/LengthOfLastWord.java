class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        // String[] str = s.trim().split(" ");
        // int len = str.length;
        // return str[len - 1].length();
        int ans = 0;
        char[] chs = s.toCharArray();
        boolean flag = false;
        for (int i = chs.length - 1; i >= 0; i--) {
            if (flag && chs[i] == ' ') {
                break;
            }
            if (chs[i] != ' ') {
                flag = true;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("   fly me   to   the moon  "));
    }
}
