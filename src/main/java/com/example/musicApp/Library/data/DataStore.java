package com.example.musicApp.Library.data;

import com.example.musicApp.Library.content.entity.Playlist;
import com.example.musicApp.Library.content.entity.Song;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Log
@Component

public class DataStore {

    private Set<Song> songs = new HashSet<>();

    private Set<Playlist> playlists = new HashSet<>();

    public synchronized List<Song> findAllSongs() {
        return new ArrayList<>(songs);
    }

    public synchronized List<Playlist> findAllPlaylists() {
        return new ArrayList<>(playlists);
    }

    public synchronized Optional<Playlist> findPlaylist(Long id) {
        return playlists.stream()
                .filter(playlist -> playlist.getId().equals(id))
                .findFirst();

    }

    public synchronized void createPlaylist(Playlist playlist) throws IllegalArgumentException {
        findPlaylist(playlist.getId()).ifPresentOrElse(
                original -> {
                    throw new IllegalArgumentException(
                            String.format("The id of playlist name \"%s\" is not unique", playlist.getId()));
                },
                () -> playlists.add(playlist));
    }

    public synchronized Optional<Song> findSong(Long id) {
        return songs.stream()
                .filter(song -> song.getId().equals(id))
                .findFirst();

    }

    public synchronized void createSong(Song song) throws IllegalArgumentException {
        findPlaylist(song.getId()).ifPresentOrElse(
                original -> {
                    throw new IllegalArgumentException(
                            String.format("The id of song name \"%s\" is not unique", song.getId()));
                },
                () -> songs.add(song));
    }

    public synchronized void deleteSong(Song song) throws IllegalArgumentException {
        findSong(song.getId()).ifPresentOrElse(
                original -> songs.remove(original),
                () -> {
                    throw new IllegalArgumentException(
                            String.format("The song with id \"%s\" does not exist", song.getId().toString()));
                });
    }

    public synchronized void deletePlaylist(Playlist playlist) throws IllegalArgumentException {
        findPlaylist(playlist.getId()).ifPresentOrElse(
                original -> playlists.remove(original),
                () -> {
                    throw new IllegalArgumentException(
                            String.format("The playlist with id \"%s\" does not exist", playlist.getId().toString()));
                });
    }
}
