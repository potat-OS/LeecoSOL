import java.util.HashMap;
import java.util.Map;

class FractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        Map<Long, Integer> modMap = new HashMap<>();
        long num = numerator;
        long denom = denominator;
        if (num % denom == 0) {
            return String.valueOf(num / denom);
        }
        if (num < 0 ^ denom < 0) {
            sb.append("-");
        }
        boolean flag = true;
        num = Math.abs(num);
        denom = Math.abs(denom);
        long res = num / denom;
        long mod = num % denom;
        sb.append(res + ".");
        int index = sb.length();
        while (flag) {
            modMap.put(mod, index);
            mod *= 10;
            res = mod / denom;
            mod %= denom;
            sb.append(res);
            Integer tmp = modMap.get(mod);
            if (tmp != null) {
                flag = false;
                sb.insert(tmp, "(");
                sb.append(")");
            }
            if (mod == 0) {
                flag = false;
            }
            index++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(-1 / -2147483648);
        System.out.println(new FractionToDecimal().fractionToDecimal(1, -2147483648));
    }
}
