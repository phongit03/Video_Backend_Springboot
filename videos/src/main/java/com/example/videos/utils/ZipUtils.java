package com.example.videos.utils;



import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils {

    public static void zip(List<File> videoFiles) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("1MinVids.zip");
        ZipOutputStream  zipOutputStream = new ZipOutputStream(fileOutputStream);
        for (File videoFile:videoFiles) {
            String extension = getFileExtension(videoFile.getName());
            FileInputStream fileInputStream = new FileInputStream(videoFile);
            ZipEntry zipEntry = new ZipEntry(videoFile.getName());
            zipOutputStream.putNextEntry(zipEntry);
            final byte[] buffer = new byte[1024];
            int len;
            while ((len=fileInputStream.read(buffer)) !=-1) {
                zipOutputStream.write(buffer,0,len);
            }
            fileInputStream.close();
            Scanner scanner = new Scanner(videoFile);
            System.out.println(extension);
            while(scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            System.out.println(videoFile.getName() + " zipped!!!");
        }
        zipOutputStream.close();
        fileOutputStream.close();
        System.out.println("1MinVids.zip created!!!");
    }
    private static String getFileExtension(String name) {
        int lastIndex = name.lastIndexOf(".");
        return name.substring(lastIndex);
    }
}
