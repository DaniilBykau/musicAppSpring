package com.example.musicApp.Library;

import com.example.musicApp.Library.content.entity.Song;
import com.example.musicApp.Library.content.service.PlaylistService;
import com.example.musicApp.Library.content.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

@Component
public class CommandLine implements CommandLineRunner {
    private PlaylistService playlistService;
    private SongService songService;

    @Autowired
    public CommandLine(PlaylistService playlistService, SongService songService) {
        this.playlistService = playlistService;
        this.songService = songService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner input = new Scanner(System.in);
        String command = "";

        while (!command.equals("q")) {
            switch (command) {
                case "a": {
                    System.out.println("Song list:");
                    for (int i = 0; i < songService.findAllSongs().size(); i++) {
                        System.out.println((i + 1) + ". " + songService.findAllSongs().get(i).getName());
                    }
                }
                case "b": {
                    System.out.println("Witch song you want to delete?");
                    command = input.next();
                    long number = Long.parseLong(command);
                    songService.delete(Objects.requireNonNull(songService.find(number).orElse(null)));
                }
                case "c": {
                    System.out.println("Witch song you want to print?");
                    command = input.next();
                    long number = Long.parseLong(command);
                    System.out.println(songService.find(number).orElse(null).getName());
                }
                case "d": {
                    System.out.println("Playlists list:");
                    for (int i = 0; i < playlistService.findAllPlaylists().size(); i++) {
                        System.out.println((i + 1) + ". " + playlistService.findAllPlaylists().get(i).getName());
                    }
                }
            }

            command = input.next();
        }
    }
}
