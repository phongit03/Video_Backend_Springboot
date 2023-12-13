package com.example.videos.entities;


import javax.persistence.*;

@Entity
@Table(name = "videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String videoName;

    private Long size;

    public Video() {

    }

    public Video(String videoName, Long size) {
        this.videoName = videoName;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }
}
