import java.util.*;

public class GetPrimeNumber {

    public static List<String> MergeRecords(Map<Integer, Integer> map) {
        int maxLen = 0;
        String KV;
        List<String> resList = new LinkedList<String>();

        for (int key : map.keySet()) {
            if (maxLen < key) {
                maxLen = key;
            }
        }
        int[] temp = new int[maxLen + 1];

        for (int key : map.keySet()) {
            temp[key] += map.get(key) + 1;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > 0) {
                KV = i + " " + String.valueOf(temp[i] - 1);
                resList.add(KV);
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            int key = in.nextInt();
            int value = in.nextInt();
            map.put(key, value + map.getOrDefault(key, 0));
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        // Iterator<String> it = MergeRecords(map).iterator();
        // while (it.hasNext()) {
        // System.out.println(it.next());
        // }
        in.close();
    }
}