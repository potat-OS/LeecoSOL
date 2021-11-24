public class OriginalDigits {
    public String originalDigits(String s) {
        StringBuilder ans = new StringBuilder();
        int[] res = new int[10];
        int[] cup = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cup[s.charAt(i) - 'a']++;
        }
        res[0] = cup['z' - 'a'];
        res[2] = cup['w' - 'a'];
        res[4] = cup['u' - 'a'];
        res[6] = cup['x' - 'a'];
        res[8] = cup['g' - 'a'];
        res[3] = cup['h' - 'a'] - res[8];
        res[5] = cup['f' - 'a'] - res[4];
        res[7] = cup['v' - 'a'] - res[5];
        res[9] = cup['i' - 'a'] - res[5] - res[6] - res[8];
        res[1] = cup['o' - 'a'] - res[0] - res[2] - res[4];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i]; j++) {
                ans.append(i);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new OriginalDigits().originalDigits(""));
    }
}
