package com.example.musicApp.Library.content.service;

import com.example.musicApp.Library.content.entity.Playlist;
import com.example.musicApp.Library.content.entity.Song;
import com.example.musicApp.Library.content.repository.PlaylistRepository;
import com.example.musicApp.Library.content.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        return repository.findById(id);
    }

    public Optional<Playlist> findByName(String name) {
        return repository.findPlaylistByName(name);
    }

    public List<Playlist> findAll() {
        return repository.findAll();
    }



    @Transactional
    public void create(Playlist playlist) {
        repository.save(playlist);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public Playlist update(Playlist playlist, Playlist newPlaylist) {
        playlist = repository.getById(playlist.getId());
        playlist.setName(newPlaylist.getName());
        repository.save(playlist);
        return playlist;
    }

}
