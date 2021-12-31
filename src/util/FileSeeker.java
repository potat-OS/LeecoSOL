package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

class FileSeeker {

    private static Map<String, String> map;

    private static void setOrg(String orgPath) {
        File org = new File(orgPath);
        if (org.isDirectory()) {
            File[] files = org.listFiles();
            for (File file : files) {
                setOrg(file.getAbsolutePath());
            }
        } else {
            String fileName = org.getName();
            String absolutePath = org.getAbsolutePath();
            map.put(fileName, map.getOrDefault(fileName, "") + absolutePath);
        }
    }

    public static void main(String[] args) {
        map = new HashMap<>();
        String orgPath = "";
        setOrg(orgPath);
        String toPath = "";
        String resPath = "";
        try (BufferedReader to = new BufferedReader(new FileReader(new File(toPath)));
                BufferedReader from = new BufferedReader(new FileReader(new File(orgPath)));
                BufferedWriter w = new BufferedWriter(new FileWriter(resPath))) {
            for (String line; (line = from.readLine()) != null;) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
