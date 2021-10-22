import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int count = 0;
        int min = nums.length / 3;
        for (int i : nums) {
            count = map.get(i) == null ? 1 : 1 + map.get(i);
            map.put(i, count);
        }
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > min) {
                ans.add(entry.getKey());
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[] { 3, 2, 3 }));
    }
}
