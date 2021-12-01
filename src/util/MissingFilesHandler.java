package util;

import java.io.*;
import java.nio.file.*;
import java.util.*;

class MissingFilesHandler {

    private final String to;
    private final String src;
    private final String logPath;
    private int arranged;
    private int overwrote;
    private int missing = 0;
    private Set<Path> set;

    private MissingFilesHandler(String src, String to, String logPath) {
        this.src = src;
        this.to = to;
        this.logPath = logPath;
        this.arranged = 0;
        this.overwrote = 0;
        this.missing = 0;
        this.set = new HashSet<>();
    }

    public static MissingFilesHandler of(String src, String to, String logPath) {
        return new MissingFilesHandler(src, to, logPath);
    }

    public void handle() {
        try (BufferedReader r = new BufferedReader(new FileReader(to));
                BufferedWriter logWriter = new BufferedWriter(new FileWriter(new File(logPath)))) {
            boolean flag = true;
            while (flag) {
                String line = r.readLine();
                if (r.readLine() == null) {
                    flag = false;
                } else if (line.split("\"").length > 1) {
                    set.add(Paths.get(line.split("\"")[1].replaceFirst("C:", "E:")));
                }
            }
            missing = set.size();
            logWriter.write(missing + " 件ミス\n");
            System.out.println(missing + " 件ミス");
            findFile(src, logWriter);
            logWriter.write(arranged + " 件配置した\n");
            System.out.println(arranged + " 件配置した");
            logWriter.write(overwrote + " 件書き換えた\n");
            System.out.println(overwrote + " 件書き換えた");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void findFile(String srcPath, BufferedWriter logWriter) throws Exception {
        File src = new File(srcPath);
        if (src.isDirectory()) {
            File[] files = src.listFiles();
            for (File srcFile : files) {
                findFile(srcFile.getAbsolutePath(), logWriter);
            }
        } else {
            for (Path path : set) {
                if (src.getName().equals(path.getFileName().toString())) {
                    new File(path.getParent().toString()).mkdirs();
                    File miss = new File(path.toString());
                    String srcFullPath = src.getAbsolutePath(), missFullPath = miss.getAbsolutePath();
                    if (!miss.exists()) {
                        Files.copy(src.toPath(), miss.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        logWriter.write("配置: [" + srcFullPath + "]-> [" + missFullPath + "]に配置\n");
                        arranged++;
                        // } else if (src.lastModified() > miss.lastModified()) {
                        // Files.copy(src.toPath(), miss.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        // logWriter.write("書換: [" + srcFullPath + "]-> [" + missFullPath + "]に書換\n");
                        // overwrote++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String to = "E:\\GLOVIA\\tmp\\11-29-2021 11-12-37 午前.txt", src = "E:\\GLOVIA\\origin",
                logPath = "E:\\GLOVIA\\tmp\\handler.log";
        long start = System.currentTimeMillis();
        MissingFilesHandler.of(src, to, logPath).handle();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
