import java.util.HashMap;
import java.util.Map;

class ToHex {

    private static final int baseHex = 16;
    private static Map<Integer, Character> hexMap = new HashMap<>() {
        {
            put(0, '0');
            put(1, '1');
            put(2, '2');
            put(3, '3');
            put(4, '4');
            put(5, '5');
            put(6, '6');
            put(7, '7');
            put(8, '8');
            put(9, '9');
            put(10, 'a');
            put(11, 'b');
            put(12, 'c');
            put(13, 'd');
            put(14, 'e');
            put(15, 'f');
        }
    };
    private static Map<Character, Character> negativeHexMap = new HashMap<>() {
        {
            put('f', '0');
            put('e', '1');
            put('d', '2');
            put('c', '3');
            put('b', '4');
            put('a', '5');
            put('9', '6');
            put('8', '7');
            put('7', '8');
            put('6', '9');
            put('5', 'a');
            put('4', 'b');
            put('3', 'c');
            put('2', 'd');
            put('1', 'e');
            put('0', 'f');
        }
    };

    public String toHex(int num) {
        String ans = "";
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num = Math.abs(num) - 1;
        } else {
            if (hexMap.get(num) != null) {
                return hexMap.get(num).toString();
            }
        }
        StringBuilder res = new StringBuilder();
        int tmp = num / baseHex;
        int mod = num % baseHex;
        res.append(hexMap.get(mod));
        while (hexMap.get(tmp) == null) {
            mod = tmp % baseHex;
            tmp = tmp / baseHex;
            res.append(hexMap.get(mod));
        }
        res.append(hexMap.get(tmp));
        if (isNegative) {
            for (int i = 0; i < 8; i++) {
                if (i < res.length()) {
                    res.setCharAt(i, negativeHexMap.get(res.charAt(i)));
                } else {
                    res.append('f');
                }
            }
        }
        ans = res.reverse().toString();
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new ToHex().toHex(0));
    }
}
