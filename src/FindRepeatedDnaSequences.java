import java.util.*;

public class FindRepeatedDnaSequences {

    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> resList = new ArrayList<>();
        StringBuilder sBuilder = new StringBuilder(s);
        for (int i = 0; i + 10 <= sBuilder.length(); i++) {
            if (map.get(sBuilder.substring(i, i + 10)) != null) {
                map.put(sBuilder.substring(i, i + 10), map.get(sBuilder.substring(i, i + 10)) + 1);
                if (map.get(sBuilder.substring(i, i + 10)) == 2) {
                    resList.add(sBuilder.substring(i, i + 10));
                }
            } else {
                map.put(sBuilder.substring(i, i + 10), 1);
            }
        }

        return resList;
    }

    public static void main(String[] args) throws Exception {
        String s = "AAAAAAAAAAA";
        Class<?> clz = Class.forName("FindRepeatedDnaSequences");
        System.out.println(
                clz.getMethod("findRepeatedDnaSequences", String.class).invoke(clz.getConstructor().newInstance(), s));
    }
}