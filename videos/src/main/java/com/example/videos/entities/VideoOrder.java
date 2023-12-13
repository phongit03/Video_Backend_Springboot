package com.example.videos.entities;

public class VideoOrder {
    private Integer order;

    private String videoId;

    public VideoOrder(int order, String videoId) {
        this.order = order;
        this.videoId = videoId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}
