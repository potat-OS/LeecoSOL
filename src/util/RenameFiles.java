package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RenameFiles {
    public static int count = 0;

    public static void rename(File file) {
        String fileName = file.getName();
        String fileParent = file.getParent();
        Path path = file.toPath();
        try {
            String originTime = Files.getLastModifiedTime(path).toString();
            int suffix = (int) file.length();
            File newFile = new File(fileParent + "\\" + ConvertTime.GMTx0ToUTCx8(originTime) + "_" + suffix
                    + fileName.substring(fileName.lastIndexOf(".")));
            if (!newFile.exists()) {
                file.renameTo(newFile);
                System.out.println("No." + count++ + " " + file.getName() + " is renamed to " + newFile.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void renameFiles(File file) {
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                renameFiles(files[i]);
            } else {
                rename(files[i]);
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\hanli\\OneDrive\\图片");
        if (file.exists()) {
            renameFiles(file);
        }
    }
}