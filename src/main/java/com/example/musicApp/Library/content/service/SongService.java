package com.example.musicApp.Library.content.service;

import com.example.musicApp.Library.content.entity.Song;
import com.example.musicApp.Library.content.repository.PlaylistRepository;
import com.example.musicApp.Library.content.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private SongRepository repository;

    @Autowired
    public SongService(SongRepository repository) {
        this.repository = repository;
    }

    public Optional<Song> find(Long id) {
        return repository.find(id);
    }

    public List<Song> findAllSongs() {
        return repository.findAll();
    }

    public void create(Song song) {
        repository.create(song);
    }

    public void delete(Song song) {
        repository.delete(repository.find(song.getId()).orElseThrow());
    }
}
