package com.example.musicApp.Library.initializer;

import com.example.musicApp.Library.content.entity.Playlist;
import com.example.musicApp.Library.content.entity.Song;
import com.example.musicApp.Library.content.service.PlaylistService;
import com.example.musicApp.Library.content.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@Component
public class InitializedData {
    private final PlaylistService playlistService;

    private final SongService songService;

    @Autowired
    public InitializedData(SongService songService, PlaylistService playlistService){
        this.songService = songService;
        this.playlistService = playlistService;
    }

    @PostConstruct
    private synchronized void init(){

        Playlist classicMusic = Playlist.builder()
                .name("classic music")
                .id(1L)
                .build();

        Playlist popularMusic = Playlist.builder()
                .name("popular music")
                .id(2L)
                .build();

        playlistService.create(classicMusic);
        playlistService.create(popularMusic);

        Song theFourSeasons = Song.builder()
                .id(1L)
                .name("The Four Seasons")
                .singer("Vivaldi")
                .duration(222)
                .playlist(classicMusic)
                .build();

        Song carmen = Song.builder()
                .id(2L)
                .name("The Four Seasons")
                .singer("Vivaldi")
                .duration(229)
                .playlist(classicMusic)
                .build();

        Song overtureFromTheMarriageOfFigaro = Song.builder()
                .id(3L)
                .name("Overture from The Marriage of Figaro")
                .singer("Mozart")
                .duration(270)
                .playlist(classicMusic)
                .build();

        Song rollingInTheDeep = Song.builder()
                .id(4L)
                .name("Rolling in the Deep")
                .singer("Adele")
                .duration(237)
                .playlist(popularMusic)
                .build();

        Song blindingLights = Song.builder()
                .id(5L)
                .name("Blinding Lights")
                .singer("The Weeknd")
                .duration(263)
                .playlist(popularMusic)
                .build();

        songService.create(theFourSeasons);
        songService.create(carmen);
        songService.create(overtureFromTheMarriageOfFigaro);
        songService.create(rollingInTheDeep);
        songService.create(blindingLights);



    }
}
