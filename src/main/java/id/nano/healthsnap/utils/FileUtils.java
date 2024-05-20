package id.nano.healthsnap.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileUtils {
    public static void createDirectories(String path) {
        new File(path).mkdirs();
    }

    public static PrintWriter getPrintWriter(String filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        return new PrintWriter(fileWriter);
    }
}
