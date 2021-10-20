public class CountSegments {
    public int countSegments(String s) {
        boolean isFirstWord = true;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                if (isFirstWord) {
                    count++;
                    isFirstWord = false;
                }
            } else {
                isFirstWord = true;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "Hello, my name is   John";
        System.out.println(new CountSegments().countSegments(s));
    }
}
