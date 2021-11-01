package com.example.musicApp.Library.content.dto;

import com.example.musicApp.Library.content.entity.Playlist;
import lombok.Data;

@Data
public class SongDto {
    private Long id;

    private String name;

    private String singer;

    private String playlist;

}
