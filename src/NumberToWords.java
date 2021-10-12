public class NumberToWords {

    private String[] grpTab = { "", "", "Thousand ", "Million ", "Billion " };
    private String[] bitNumTab = { "", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ",
            "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ",
            "Nineteen " };
    private String[] decNumTab = { "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ",
            "Ninety " };
    private String[] hunNumTab = { "", "One Hundred ", "Two Hundred ", "Three Hundred ", "Four Hundred ",
            "Five Hundred ", "Six Hundred ", "Seven Hundred ", "Eight Hundred ", "Nine Hundred " };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder numStr = new StringBuilder(String.valueOf(num));
        StringBuilder resStr = new StringBuilder();
        int grpLen1st = numStr.length() % 3;
        int grpLen = numStr.length() / 3;
        if (grpLen1st != 0) {
            resStr.append((Integer.parseInt(numStr.substring(0, grpLen1st)) < bitNumTab.length
                    ? bitNumTab[Integer.parseInt(numStr.substring(0, grpLen1st))]
                    : decNumTab[Integer.parseInt(numStr.substring(0, 1)) - 2]
                            + bitNumTab[Integer.parseInt(numStr.substring(1, 2))])
                    + grpTab[grpLen + 1]);
        }
        int index = grpLen1st;
        for (int i = grpLen; i > 0; i--) {

            if (!numStr.substring(index, index + 3).equals("000")) {
                resStr.append((Integer.parseInt(numStr.substring(index + 1, index + 3)) < bitNumTab.length
                        ? hunNumTab[Integer.parseInt(numStr.substring(index, index + 1))]
                                + bitNumTab[Integer.parseInt(numStr.substring(index + 1, index + 3))]
                        : hunNumTab[Integer.parseInt(numStr.substring(index, index + 1))]
                                + decNumTab[Integer.parseInt(numStr.substring(index + 1, index + 2)) - 2]
                                + bitNumTab[Integer.parseInt(numStr.substring(index + 2, index + 3))])
                        + grpTab[i]);
            }
            index += 3;
        }
        return resStr.toString().trim();
    }

    public static void main(String[] args) throws Exception {
        Class<?> clz = Class.forName("NumberToWords");
        System.out.println(
                (String) clz.getMethod("numberToWords", int.class).invoke(clz.getConstructor().newInstance(), 0));
    }
}
