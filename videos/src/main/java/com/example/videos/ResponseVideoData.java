package com.example.videos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVideoData {

    private String videoName;

    private String downloadUrl;

    private long fileSize;


}
