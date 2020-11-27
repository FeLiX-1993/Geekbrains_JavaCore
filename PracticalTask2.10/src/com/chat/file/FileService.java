package com.chat.file;

import java.io.*;

public class FileService {

    private FileService() {
    }

    public static void appendToFile(String fileName, String s) {

        File file = new File(fileName);
        boolean isNewFile = !file.exists();

        try (BufferedWriter buf = new BufferedWriter(new FileWriter(fileName, true))) {
            if (!isNewFile)
                buf.newLine();
            buf.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getLastLineFromFile(String fileName, int countOfLines) {

        File file = new File(fileName);
        if (!file.exists())
            return "";

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {

            if (raf.length() == 0)
                    return "";

            int currentCountOfLines = 0;
            StringBuilder sb = new StringBuilder("");
            long pos = raf.length()-1;
            char c;

            while (pos >= 0) {
                raf.seek(pos);
                c = (char)raf.read();
                if (c == '\n')
                    currentCountOfLines += 1;
                if (currentCountOfLines == countOfLines)
                    break;
                sb.append(c);
                pos -= 1;
            }

            return sb.reverse().toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
