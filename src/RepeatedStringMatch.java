class RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {
        int an = a.length(), bn = b.length();
        int index = strStr(a, b);
        if (index == -1) {
            return -1;
        }
        if (an - index >= bn) {
            return 1;
        }
        return (bn + index - an - 1) / an + 2;
    }

    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i - j < n; i++) { // b 开始匹配的位置是否超过第一个叠加的 a
            while (j > 0 && haystack.charAt(i % n) != needle.charAt(j)) { // haystack 是循环叠加的字符串，所以取 i % n
                j = pi[j - 1];
            }
            if (haystack.charAt(i % n) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/repeated-string-match/solution/zhong-fu-die-jia-zi-fu-chuan-pi-pei-by-l-vnye/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。