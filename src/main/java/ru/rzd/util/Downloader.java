package ru.rzd.util;

import java.io.File;

public class Downloader {

    public static boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        String[] dirContents = dir.list();


        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].equals(fileName)) {

                break;
            }
        }
        return true;
    }
}
