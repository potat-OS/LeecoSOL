class LongestPalindrome {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int max = 0, left = 0, right = 0;
        for (int i = 0; i < len; i++) {
            int l = i, r = i;
            // 确定中心
            while (r < len - 1 && chars[l] == chars[r + 1]) {
                r++;
            }
            // 中心扩散
            while (l >= 1 && r < len - 1 && chars[l - 1] == chars[r + 1]) {
                l--;
                r++;
            }
            int tmp = r - l;
            if (tmp > max) {
                max = tmp;
                left = l;
                right = r;
            }
        }
        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("上海自来水来自海上"));
    }
}
