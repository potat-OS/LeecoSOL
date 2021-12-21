public class DayOfYear {
    public int dayOfYear(String date) {
        int year = Integer.valueOf(date.substring(0, 4));
        int month = Integer.valueOf(date.substring(5, 7));
        int day = Integer.valueOf(date.substring(8));
        int febDays = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0) ? 29 : 28;
        int[] cnt = { 31, febDays, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int ans = day;
        for (int i = 0; i < month - 1; i++) {
            ans += cnt[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new DayOfYear().dayOfYear("2021-12-21"));
    }
}
