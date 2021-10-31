package com.example.musicApp.Library.content.service;

import com.example.musicApp.Library.content.entity.Song;
import com.example.musicApp.Library.content.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        return repository.findById(id);
    }


    public List<Song> findAll() {
        return repository.findAll();
    }


    @Transactional
    public Song create(Song song) {
        repository.save(song);
        return song;
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public Song update(Song song, Song newSong) {
        Song songToChange = repository.getById(song.getId());
        songToChange.setName(newSong.getName());
        songToChange.setSinger(newSong.getSinger());
        repository.save(songToChange);
        return songToChange;
    }
}
