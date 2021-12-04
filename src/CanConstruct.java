class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] m = new int[26];
        for (char c : magazine.toCharArray()) {
            m[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (--m[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CanConstruct().canConstruct("ransomNote", "magazine"));
    }
}
