package com.example.musicApp.Library.content.dto;

import lombok.Data;

import java.util.Set;
import java.util.stream.Stream;

@Data
public class PlaylistDto {
    private Long id;

    private String name;

    private Stream<String> songs;
}
