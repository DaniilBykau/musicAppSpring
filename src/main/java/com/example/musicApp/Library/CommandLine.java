package com.example.musicApp.Library;

import com.example.musicApp.Library.content.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLine implements CommandLineRunner {
    private PlaylistService playlistService;

    @Autowired
    public CommandLine(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void run(String... args) throws Exception {
        playlistService.findAllPlaylists().forEach(System.out::println);
    }
}
