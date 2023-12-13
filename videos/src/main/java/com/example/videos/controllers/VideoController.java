package com.example.videos.controllers;

import com.example.videos.ResponseVideoData;
import com.example.videos.entities.Video;
import com.example.videos.services.VideoService;
import com.example.videos.utils.VideoDownloadUtils;
import com.example.videos.utils.VideoUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping(path = "/api/v1/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping
    public Resource getAllVideos() throws IOException {
        return VideoDownloadUtils.getVideoFileAsResource();
    }

    @PostMapping
    public ResponseVideoData uploadVideo(@RequestParam(value = "file") MultipartFile videoFile) throws Exception {

        String urlDownload = "/downloadVideo/";

        String videoFileId = VideoUploadUtil.saveVideoFile(StringUtils.cleanPath(Objects.requireNonNull(videoFile.getOriginalFilename())), videoFile);

        return new ResponseVideoData(
                videoFile.getOriginalFilename(),
                urlDownload + videoFileId,
                videoFile.getSize()
        );

    }

    @DeleteMapping()
    public void deleteAllVideos() {
        videoService.deleteAll();
    }
}
