package util;
import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * @apiNote Search in local folder which is provided for logfile based missing
 *          file list
 * @author Han.Linjue
 */
class MissingFilesHandler {

    // missing file list
    private List<Path> misFilePathList;
    // count of successfully written files
    private int count = 0;
    // count of repeated files
    private int repeated = 0;

    /**
     * @apiNote get missing file list by read log file
     * @param logFilePath Path of log file
     */
    public void setMissingFileList(String logFilePath) {
        boolean readFlag = true;
        misFilePathList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) {
            while (readFlag) {
                String str = reader.readLine();
                if (reader.readLine() == null) {
                    readFlag = false;
                } else {
                    // When this line have "(means path)
                    if (str.split("\"").length > 1) {
                        // Split lines by " to get absolutePath of missing file
                        Path missingFilePath = Paths.get(str.split("\"")[1]);
                        // Change root path of copy to
                        Path resultPath = Paths.get(missingFilePath.toString().replaceFirst("C:", "E:"));
                        misFilePathList.add(resultPath);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @apiNote search missing files and copy them
     * @param srcFilePath
     * @return count of successfully written files
     */
    public int findMissingFile(String srcFilePath) {
        try {
            File src = new File(srcFilePath);
            File[] srcFiles = src.listFiles();
            for (File srcFile : srcFiles) {
                if (srcFile.isDirectory()) {
                    findMissingFile(srcFile.getAbsolutePath());
                } else if (srcFile.isFile()) {
                    for (Path misFilePath : misFilePathList) {
                        if (srcFile.getName().equals(misFilePath.getFileName().toString())) {
                            File misDir = new File(misFilePath.getParent().toString());
                            File misFile = new File(misFilePath.toString());
                            if (!misDir.exists()) {
                                misDir.mkdirs();
                            }
                            if (!misFile.exists()) {
                                Files.copy(srcFile.toPath(), misFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                                System.out.println("モジュール： " + misFile.getAbsolutePath() + " が配置しました。");
                                count++;

                            } else {
                                if (srcFile.lastModified() > misFile.lastModified()) {
                                    Files.copy(srcFile.toPath(), misFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                                    System.out.println("古いモジュール： " + misFile.getAbsolutePath() + " が書き換えた。");
                                    repeated++;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public int getRepeated() {
        return this.repeated;
    }

    public static void main(String[] args) {
        String pathTo = "E:\\Temp\\8-19-2021 04-39-32 午後.txt";
        String srcFilePath = "E:\\GLOVIA\\svn\\cloud-dev\\branches\\MyNumberiZ";

        MissingFilesHandler handler = new MissingFilesHandler();
        handler.setMissingFileList(pathTo);
        System.out.println("モジュールを " + handler.findMissingFile(srcFilePath) + " 件配置しました。");
        System.out.println("古いモジュールを書き換えのは " + handler.getRepeated() + " 件あっています。");
    }
}