class DetectCapitalUse {
    public boolean detectCapitalUse(String word) {
        boolean ans = true;
        if (word.length() == 1) {
            return ans;
        }
        int upperMax = '[';
        boolean is1stUpper = word.charAt(0) < upperMax;
        int length = is1stUpper ? word.length() - 1 : word.length();
        for (int i = 1; i < length; i++) {
            if (is1stUpper) {
                if (word.charAt(i) / upperMax != word.charAt(i + 1) / upperMax) {
                    ans = false;
                }
            } else {
                if (word.charAt(i) < upperMax) {
                    ans = false;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String word = "USA";
        System.out.println(new DetectCapitalUse().detectCapitalUse(word));
    }
}
