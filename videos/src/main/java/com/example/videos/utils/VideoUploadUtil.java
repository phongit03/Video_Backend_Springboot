package com.example.videos.utils;

import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class VideoUploadUtil {
    public static String saveVideoFile(String videoFileName, MultipartFile multipartVideoFile) throws IOException {
        Path uploadDir = Paths.get("D:\\working\\Java Projects\\videos\\videos\\1MinVids");

        String videoFileId = RandomStringUtils.randomAlphabetic(8);

        try (InputStream inputStream = multipartVideoFile.getInputStream()) {
            Path videoFilePath = uploadDir.resolve(videoFileId + "-" + videoFileName);
            Files.copy(inputStream,videoFilePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IOException("Error saving uploaded video: "+videoFileName, e);
        }
        return videoFileId;
    }
}
