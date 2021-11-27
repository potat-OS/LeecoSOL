package util;

import java.util.function.Function;

public class Converter {

    private int[] parts;

    private Converter(Function<String, Integer> func, String GMTx0) {
        parts = new int[6];
        parts[0] = func.apply(GMTx0.substring(0, 4));
        for (int i = 1, j = 5; i < parts.length; i++, j += 3) {
            parts[i] = func.apply(GMTx0.substring(j, j + 2));
        }
    }

    public static Converter of(String GMTx0) {
        return new Converter(Integer::parseInt, GMTx0);
    }

    public String GMTx0ToUTCx8() {
        int idx = 3, maxDay, maxMonth = 12, maxHour = 24;
        boolean isLeap = parts[0] % 400 == 0 || (parts[0] % 4 == 0 && parts[0] % 100 != 0), isContinue = true;
        while (idx >= 0 && isContinue) {
            switch (idx) {
            case 3:
                isContinue = (parts[idx] += 8) >= maxHour;
                parts[idx] += isContinue ? -maxHour : 0;
                break;
            case 2:
                maxDay = parts[1] == 2 ? (isLeap ? 29 : 28)
                        : (parts[1] == 4 || parts[1] == 6 || parts[1] == 9 || parts[1] == 11 ? 30 : 31);
                isContinue = (++parts[idx]) > maxDay;
                parts[idx] += isContinue ? -maxDay : 0;
                break;
            case 1:
                isContinue = (parts[idx] + 1) > maxMonth;
                parts[idx] += isContinue ? -maxMonth : 1;
                break;
            case 0:
                parts[idx]++;
                break;
            default:
                break;
            }
            idx--;
        }
        StringBuilder res = new StringBuilder();
        String prefix = "0";
        res.append(String.valueOf(parts[0]).substring(2, 4));
        for (int i = 1; i < parts.length; i++) {
            res.append(i != 2 ? (parts[i] < 10 ? prefix + parts[i] : parts[i])
                    : (parts[i] < 10 ? prefix + parts[i] : parts[i]) + "-");
        }
        return res.toString();
    }
}
