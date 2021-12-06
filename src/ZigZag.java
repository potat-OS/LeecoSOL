class ZigZag {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int gap = numRows - 2;
        int totalGap = gap + numRows;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < arr.length; j += totalGap) {
                sb.append(arr[j]);
                int gGap = j + 2 * gap;
                if (i > 0 && i < numRows - 1 && gGap < arr.length) {
                    sb.append(arr[gGap]);
                }
            }
            gap -= i < 1 ? 0 : 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ZigZag().convert("PAYPALISHIRING", 4));
    }
}
