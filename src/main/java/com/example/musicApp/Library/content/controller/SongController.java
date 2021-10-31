package com.example.musicApp.Library.content.controller;


import com.example.musicApp.Library.content.dto.SongDto;
import com.example.musicApp.Library.content.dto.converter.SongConverter;
import com.example.musicApp.Library.content.entity.Song;
import com.example.musicApp.Library.content.service.PlaylistService;
import com.example.musicApp.Library.content.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/songs")
public class SongController {

    private SongService songService;

    private PlaylistService playlistService;

    @Autowired
    SongConverter songConverter;


    @Autowired
    public SongController(SongService songService, PlaylistService playlistService) {
        this.playlistService = playlistService;
        this.songService = songService;
    }

    @GetMapping
    public List<SongDto> findAll() {
        List<Song> songs = songService.findAll();
        return songConverter.entityToDto(songs);
    }

    @GetMapping("{ID}")
    public SongDto findById(@PathVariable(value = "ID") Long id) {
        Song song = songService.find(id).orElse(null);
        if (song == null) {
            return null;
        }
        return songConverter.entityToDto(song);
    }

    @PostMapping
    public SongDto save(@RequestBody SongDto dto) {
        Song song = songConverter.dtoToEntityCreateAndUpdate(dto);
        song = songService.create(song);
        return songConverter.entityToDtoCreateAndUpdate(song);
    }

    @PutMapping("{ID}")
    public SongDto update(@PathVariable(value = "ID") Long id, @RequestBody Song newSong) {
        Song song = songService.find(id).orElse(null);
        song = songService.update(song, newSong);
        return songConverter.entityToDtoCreateAndUpdate(song);
    }

    @DeleteMapping("{ID}")
    public void delete(@PathVariable(value = "ID") Long id) {
        songService.delete(id);
    }
}
