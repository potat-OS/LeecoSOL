class MaxPower {
    public int maxPower(String s) {
        int ans = 1, cnt = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            ans = Math.max(cnt = chars[i] == chars[i + 1] ? cnt + 1 : 1, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaxPower().maxPower("leetcode"));
    }
}
