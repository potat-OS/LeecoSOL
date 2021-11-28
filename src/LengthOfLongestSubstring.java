import java.util.*;

class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        boolean flag = true;
        int count = 0;
        StringBuilder sBuilder = new StringBuilder(s);
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < sBuilder.length(); i++) {
            if (map.get(sBuilder.charAt(i)) != null) {
                i = map.get(sBuilder.charAt(i));
                map.clear();
                flag = false;
            } else {
                map.put(sBuilder.charAt(i), i);
            }
            if (map.size() > count) {
                count = map.size();
            }
        }
        if (flag) {
            return sBuilder.length();
        } else {
            return count;
        }
    }

    public static void main(String[] args) throws Exception {
        String s = "aau";
        Class<?> clz = Class.forName("LengthOfLongestSubstring");
        System.out.println(
                clz.getMethod("lengthOfLongestSubstring", String.class).invoke(clz.getConstructor().newInstance(), s));
    }

}
