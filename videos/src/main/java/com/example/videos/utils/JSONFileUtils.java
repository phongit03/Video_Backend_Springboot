package com.example.videos.utils;


import com.example.videos.entities.VideoOrder;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class JSONFileUtils {
    public static void jsonGenerate(List<File> videoFiles) throws IOException {
        int order = 1;
        ObjectMapper mapper = new ObjectMapper();
        List<VideoOrder> list = new ArrayList<>();
        for (File videoFile : videoFiles) {
            String videoId = videoFile.getName().substring(0,8);
            String extension = getFileExtension(videoFile.getName());
            if(extension.equals(".json")) continue;
            list.add(new VideoOrder(order,videoId));
            order++;
        }
        mapper.writeValue(new File("D:\\working\\Java Projects\\videos\\videos\\1MinVids\\VideoOrder.json"), list);
        System.out.println("VideoOrder.json created!!!!!!!!");
    }

    private static String getFileExtension(String name) {
        int lastIndex = name.lastIndexOf(".");
        return name.substring(lastIndex);
    }


}
