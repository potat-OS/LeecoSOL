class ToLowerCase {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            sb.append(chs[i] >= 65 && chs[i] <= 90 ? chs[i] |= 32 : chs[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ToLowerCase().toLowerCase("LOVEly@@"));
    }
}
