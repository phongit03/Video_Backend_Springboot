package com.example.videos.services;


import com.example.videos.entities.Video;
import com.example.videos.repositories.VideoRepository;
import com.example.videos.utils.VideoUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class VideoService {
    @Autowired
    private VideoRepository videoRepository;

    public Video saveVideo(MultipartFile videoFile) throws Exception {
        String videoFileName = StringUtils.cleanPath(videoFile.getOriginalFilename());
        try {
            if(videoFileName.contains("..")) {
                throw new Exception("File name invalid!");
            }
            Video video = new Video(videoFileName, videoFile.getSize());
//            VideoUploadUtil.saveVideoFile(videoFileName, videoFile);
            return videoRepository.save(video);
        }
        catch (Exception e) {
            throw new Exception("Could not save file: " + videoFileName);
        }
    }

    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    public void deleteAll() {
        videoRepository.deleteAll();
    }
}
