package util;

public class ConvertTime {
    public static String GMTx0ToUTCx8(String GMTx0) {
        StringBuilder sb = new StringBuilder();
        int year = Integer.parseInt(GMTx0.substring(0, 4));
        int month = Integer.parseInt(GMTx0.substring(5, 7));
        int day = Integer.parseInt(GMTx0.substring(8, 10));
        int hour = Integer.parseInt(GMTx0.substring(11, 13));
        int minute = Integer.parseInt(GMTx0.substring(14, 16));
        int seconds = Integer.parseInt(GMTx0.substring(17, 19));
        int[] timeArr = { year, month, day, hour };
        boolean isLeapYear = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        for (int i = timeArr.length - 1; i >= 0; i--) {
            if (i == 0) {
                year++;
                break;
            } else if (i == 1) {
                timeArr[i]++;
                if (timeArr[i] > 12) {
                    timeArr[i] -= 12;
                } else {
                    break;
                }
            } else if (i == 2) {
                timeArr[i]++;
                if (isLeapYear) {
                    if (month == 2 && timeArr[i] > 29) {
                        timeArr[i] -= 29;
                    } else if ((month == 4 || month == 6 || month == 9 || month == 11) && timeArr[i] > 30) {
                        timeArr[i] -= 30;
                    } else if (day > 31) {
                        timeArr[i] -= 31;
                    } else {
                        break;
                    }
                } else {
                    if (month == 2 && timeArr[i] > 28) {
                        timeArr[i] -= 29;
                    } else if ((month == 4 || month == 6 || month == 9 || month == 11) && timeArr[i] > 30) {
                        timeArr[i] -= 30;
                    } else if (day > 31) {
                        timeArr[i] -= 31;
                    } else {
                        break;
                    }
                }
            } else {
                timeArr[i] += 8;
                if (timeArr[i] >= 24) {
                    timeArr[i] -= 24;
                } else {
                    break;
                }
            }
        }
        if (timeArr[0] % 2000 < 10) {
            sb.append(0);
        }
        sb.append(timeArr[0] % 2000);
        if (timeArr[1] < 10) {
            sb.append(0);
        }
        sb.append(timeArr[1]);
        if (timeArr[2] < 10) {
            sb.append(0);
        }
        sb.append(timeArr[2]);
        if (timeArr[3] < 10) {
            sb.append(0);
        }
        sb.append("-");
        sb.append(timeArr[3]);
        if (minute < 10) {
            sb.append(0);
        }
        sb.append(minute);
        if (seconds < 10) {
            sb.append(0);
        }
        sb.append(seconds);
        return sb.toString();
    }
}
