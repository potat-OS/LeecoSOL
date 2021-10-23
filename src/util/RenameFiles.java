package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class RenameFiles {
    public static int count = 0;

    public static void rename(File file) {
        String fileName = file.getName();
        String fileParentPath = file.getParent();
        Path path = file.toPath();
        String createdTime = "";
        try {
            String originTime = Files.getLastModifiedTime(path).toString();
            int year = Integer.parseInt(originTime.substring(0, 4));
            int month = Integer.parseInt(originTime.substring(5, 7));
            int day = Integer.parseInt(originTime.substring(8, 10));
            int hour = Integer.parseInt(originTime.substring(11, 13));
            int minute = Integer.parseInt(originTime.substring(14, 16));
            int seconds = Integer.parseInt(originTime.substring(17, 19));
            int[] timeArr = { year, month, day, hour };
            boolean isR = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
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
                    if (isR) {
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
                    if (timeArr[i] + 8 >= 24) {
                        timeArr[i] -= 24;
                    } else {
                        break;
                    }
                }
            }
            for (int t : timeArr) {
                createdTime += t + "-";
            }
            createdTime += minute + "-" + seconds + "-" + originTime.substring(20);
            File newFile = new File(
                    fileParentPath + "\\" + createdTime + fileName.substring(fileName.lastIndexOf(".")));
            if (!newFile.exists()) {
                file.renameTo(newFile);
                System.out.println("No." + count++ + " " + file.getName() + " is renamed to" + newFile.getName());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\hanli\\OneDrive\\图片\\memories\\");
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            rename(files[i]);
        }
    }
}