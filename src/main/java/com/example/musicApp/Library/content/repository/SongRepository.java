package com.example.musicApp.Library.content.repository;

import com.example.musicApp.Library.data.DataStore;
import com.example.musicApp.Library.repository.Repository;
import com.example.musicApp.Library.content.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class SongRepository implements Repository<Song, Long> {

    private DataStore store;

    @Autowired
    public SongRepository(DataStore store) {
        this.store = store;
    }

    @Override
    public Optional<Song> find(Long id) {
        return store.findSong(id);
    }

    @Override
    public List<Song> findAll() {
        return store.findAllSongs();
    }

    @Override
    public void create(Song song) {
        store.createSong(song);
    }

    @Override
    public void delete(Song song) {
        store.deleteSong(song);
    }
}
