import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindAnagrams {
    // int[] pArr = new int[26];

    // public List<Integer> findAnagrams(String s, String p) {
    //     char[] pChars = p.toCharArray();
    //     int pLen = pChars.length;
    //     for (int i = 0; i < pLen; i++) {
    //         pArr[pChars[i] - 'a']++;
    //     }
    //     List<Integer> ans = new ArrayList<>();
    //     for (int i = 0; i <= s.length() - pLen; i++) {
    //         if (isAnagram(s.substring(i, i + pLen).toCharArray())) {
    //             ans.add(i);
    //         }
    //     }
    //     return ans;
    // }

    // private boolean isAnagram(char[] sChars) {
    //     int[] sArr = new int[26];
    //     for (int i = 0; i < sChars.length; i++) {
    //         sArr[sChars[i] - 'a']++;
    //     }
    //     return Arrays.compare(pArr, sArr) == 0;
    // }

    public List<Integer> findAnagrams(String s, String p) {
        char[] pArr = p.toCharArray(), sArr = s.toCharArray();
        int pLen = pArr.length, sLen = sArr.length;
        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        int[] pCounts = new int[26], sCounts = new int[26];
        for (int i = 0; i < pLen; i++) {
            pCounts[pArr[i] - 'a']++;
            sCounts[sArr[i] - 'a']++;
        }
        List<Integer> ans = new ArrayList<>();
        if (Arrays.equals(sCounts, pCounts)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; i++) {
            sCounts[sArr[i] - 'a']--;
            sCounts[sArr[i + pLen] - 'a']++;

            if (Arrays.equals(sCounts, pCounts)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "baa", p = "aa";
        FindAnagrams anagrams = new FindAnagrams();
        anagrams.findAnagrams(s, p);
    }
}
