package com.example.musicApp.Library.content.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Log
@SuperBuilder
@Component
public class Playlist {
    private Long id;
    private String name;
    private List<Song> songs;

}
