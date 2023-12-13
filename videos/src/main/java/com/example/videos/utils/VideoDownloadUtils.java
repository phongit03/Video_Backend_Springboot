package com.example.videos.utils;

import org.springframework.core.io.UrlResource;

import org.springframework.core.io.Resource;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class VideoDownloadUtils {

    public static Resource getVideoFileAsResource() throws IOException {
        Path uploadDir = Paths.get("D:\\working\\Java Projects\\videos\\videos\\1MinVids");

        List<File> videoFiles = Arrays.stream(Objects.requireNonNull(uploadDir.toFile().listFiles())).toList();

//        JSONFileUtils.jsonGenerate(videoFiles);

        ZipUtils.zip(videoFiles);

        Path zipFilePath = Paths.get("D:\\working\\Java Projects\\videos\\1MinVids.zip");

        return new UrlResource(zipFilePath.toUri());
    }
}
