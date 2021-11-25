public class OriginalDigits {
    public String originalDigits(String s) {
        StringBuilder ans = new StringBuilder();
        int[] res = new int[10];
        int[] cup = new int[26];
        for (int i : s.toCharArray()) {
            cup[i - 97]++;
        }
        res[0] = cup[25];
        res[2] = cup[22];
        res[4] = cup[20];
        res[6] = cup[23];
        res[8] = cup[6];
        res[3] = cup[7] - res[8];
        res[5] = cup[5] - res[4];
        res[7] = cup[21] - res[5];
        res[9] = cup[8] - res[5] - res[6] - res[8];
        res[1] = cup[14] - res[0] - res[2] - res[4];
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
