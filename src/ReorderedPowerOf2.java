import java.util.HashMap;
import java.util.Map;

public class ReorderedPowerOf2 {

    private static Map<Integer, String> map = new HashMap<>() {
        {
            put(1, "");
            put(2, "");
            put(4, "");
            put(8, "");
            put(16, "");
            put(32, "");
            put(46, "");
            put(128, "");
            put(256, "");
            put(512, "");
            put(1024, "");
            put(2048, "");
            put(4096, "");
            put(8192, "");
            put(16384, "");
            put(32768, "");
            put(65536, "");
            put(131072, "");
            put(262144, "");
            put(524288, "");
            put(1048576, "");
            put(2097152, "");
            put(4194304, "");
            put(8388608, "");
            put(16777216, "");
            put(33554432, "");
            put(67108864, "");
            put(134217728, "");
            put(268435456, "");
            put(536870912, "");
        }
    };

    public boolean reorderedPowerOf2(int n) {
        if (is2Pow(n)) {
            return true;
        }
        char[] nStr = String.valueOf(n).toCharArray();
        for (int i = 0; i < nStr.length; i++) {
            int index = 0;
            for (int j = 0; j < nStr.length; j++) {
                if ((nStr[index] != '0' || j != 0) && nStr[index] != nStr[j]) {
                    char tmp = nStr[j];
                    nStr[j] = nStr[index];
                    nStr[index] = tmp;
                    index++;
                    if (is2Pow(String.valueOf(nStr))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean is2Pow(int n) {
        return map.get(n) != null ? true : false;
    }

    private boolean is2Pow(String n) {
        if (n.charAt(0) == '0') {
            return false;
        }
        return is2Pow(Integer.parseInt(n));
    }

    public static void main(String[] args) {
        System.out.println(new ReorderedPowerOf2().reorderedPowerOf2(8219));
    }
}
