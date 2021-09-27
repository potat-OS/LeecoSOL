import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HexToDecimal {

    public static final int BaseHex = 16;
    public static Map<Character, String> HexMap = new HashMap<Character, String>() {
        {
            put('0', "0");
            put('1', "1");
            put('2', "2");
            put('3', "3");
            put('4', "4");
            put('5', "5");
            put('6', "6");
            put('7', "7");
            put('8', "8");
            put('9', "9");
            put('A', "10");
            put('B', "11");
            put('C', "12");
            put('D', "13");
            put('E', "14");
            put('F', "15");
            put('a', "10");
            put('b', "11");
            put('c', "12");
            put('d', "13");
            put('e', "14");
            put('f', "15");
        }
    };

    public static int HexToDec(String hexString) {

        int decimal = 0;
        hexString = hexString.substring(2);
        for (Character hex : hexString.toCharArray()) {
            decimal = decimal * BaseHex + Integer.parseInt(HexMap.get(hex));
        }
        return decimal;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String hexString = in.next();
            int res = HexToDec(hexString);
            System.out.println(res);
        }
        in.close();
    }
}
