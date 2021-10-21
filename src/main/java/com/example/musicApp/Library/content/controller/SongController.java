package com.example.musicApp.Library.content.controller;


import com.example.musicApp.Library.content.dto.SongDto;
import com.example.musicApp.Library.content.dto.converter.SongConverter;
import com.example.musicApp.Library.content.entity.Song;
import com.example.musicApp.Library.content.service.PlaylistService;
import com.example.musicApp.Library.content.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
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



    @GetMapping("test")
    public String test() {
        return "test";
    }

    @GetMapping("findAll")
    public List<SongDto> findAll(){
        List<Song> songs = songService.findAll();
        return songConverter.entityToDto(songs);
    }

    @GetMapping("find/{ID}")
    public SongDto findById(@PathVariable(value = "ID") Long id){
        Song song = songService.find(id).orElse(null);
        return songConverter.entityToDto(song);
    }

    @PostMapping("save")
    public SongDto save(@RequestBody SongDto dto){
        Song song = songConverter.dtoToEntity(dto);
        song = songService.create(song);
        return songConverter.entityToDto(song);
    }

    @PutMapping("update/{ID}")
    public  void update(@PathVariable(value = "ID") Long id){
        Song song = songService.find(id).orElse(null);
        songService.update(song);
    }

    @DeleteMapping("delete/{ID}")
    public void delete(@PathVariable(value = "ID") Long id){
        songService.delete(id);
    }
}
