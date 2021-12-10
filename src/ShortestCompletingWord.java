import java.util.Arrays;

class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int ans = 0, len = 1000;
        // 初始化license Map
        int[] lic = new int[26];
        for (char c : licensePlate.toCharArray()) {
            int low = Character.toLowerCase(c) - 'a';
            // 字符限定为'a'-'z'
            if (low >= 0 && low <= 25) {
                lic[low]++;
            }
        }
        for (int i = 0; i < words.length; i++) {
            // 记录当前长度
            int tmpLen = words[i].length();
            // 长度最小时记录答案
            if (isContain(lic, words[i].toCharArray()) && tmpLen < len) {
                len = tmpLen;
                ans = i;
            }
        }
        return words[ans];
    }

    // 查找word中是否存在license的所有字符
    private boolean isContain(int[] lic, char[] word) {
        // 建立一个临时记录表记录word中license的字符
        int[] cnt = new int[26];
        for (int i = 0; i < word.length; i++) {
            int idx = word[i] - 'a';
            // 增加临时表中与license表不同的位置
            // 如果word中有license的所有字符，则临时表最终与license表相同
            cnt[idx] += lic[idx] != cnt[idx] ? 1 : 0;
        }
        return Arrays.equals(lic, cnt);
    }

    public static void main(String[] args) {
        System.out.println(new ShortestCompletingWord().shortestCompletingWord(
                "GrC8950", new String[] {
                        "measure", "other", "every", "base", "according",
                        "level", "meeting", "none", "marriage", "rest" }));
    }
}
