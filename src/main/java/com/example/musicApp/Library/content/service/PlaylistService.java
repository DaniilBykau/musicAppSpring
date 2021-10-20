package com.example.musicApp.Library.content.service;

import com.example.musicApp.Library.content.entity.Playlist;
import com.example.musicApp.Library.content.entity.Song;
import com.example.musicApp.Library.content.repository.PlaylistRepository;
import com.example.musicApp.Library.content.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    private PlaylistRepository repository;

    @Autowired
    public PlaylistService(PlaylistRepository repository) {
        this.repository = repository;
    }

    public Optional<Playlist> find(Long id) {
        return repository.find(id);
    }

    public List<Playlist> findAllPlaylists() {
        return repository.findAll();
    }

    public void create(Playlist playlist) {
        repository.create(playlist);
    }

    public void delete(Playlist playlist) {
        repository.delete(repository.find(playlist.getId()).orElseThrow());
    }
}
