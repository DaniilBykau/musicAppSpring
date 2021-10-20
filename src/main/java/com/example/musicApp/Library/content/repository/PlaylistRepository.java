package com.example.musicApp.Library.content.repository;

import com.example.musicApp.Library.content.entity.Playlist;
import com.example.musicApp.Library.data.DataStore;
import com.example.musicApp.Library.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class PlaylistRepository implements Repository<Playlist, Long> {

    private DataStore store;

    @Autowired
    public PlaylistRepository(DataStore store) {
        this.store = store;
    }

    @Override
    public Optional<Playlist> find(Long id) {
        return store.findPlaylist(id);
    }

    @Override
    public List<Playlist> findAll() {
        return store.findAllPlaylists();
    }

    @Override
    public void create(Playlist playlist) {
        store.createPlaylist(playlist);
    }

    @Override
    public void delete(Playlist playlist) {
        store.deletePlaylist(playlist);
    }
}
