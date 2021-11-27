package util;

import java.io.File;
import java.nio.file.Files;

class RenameFilesByTime {
    private int count = 0;

    private RenameFilesByTime() {
    }

    public static RenameFilesByTime of() {
        return new RenameFilesByTime();
    }

    public void renameFiles(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                renameFiles(f.getAbsolutePath());
            }
        } else {
            try {
                rename(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void rename(File file) throws Exception {
        String fileName = file.getName(), GMTTime = Files.getLastModifiedTime(file.toPath()).toString(),
                UTCTime = Converter.of(GMTTime).GMTx0ToUTCx8(), suffix = fileName.substring(fileName.lastIndexOf("."));
        File newFile = new File(file.getParent() + "\\" + UTCTime + "_" + file.length() + suffix);
        if (!newFile.exists()) {
            System.out.println(
                    "No." + ++count + " " + fileName + " is renamed to " + newFile.getName() + file.renameTo(newFile));
        }
    }

    public static void main(String[] args) {
        // D:\\00_BackUp\\Photos
        // C:\\Users\\hanli\\OneDrive\\图片
        String path = "C:\\Users\\hanli\\OneDrive\\图片";
        RenameFilesByTime.of().renameFiles(path);
    }
}