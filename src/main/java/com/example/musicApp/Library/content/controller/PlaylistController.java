package com.example.musicApp.Library.content.controller;

import com.example.musicApp.Library.content.dto.PlaylistDto;
import com.example.musicApp.Library.content.dto.SongDto;
import com.example.musicApp.Library.content.dto.converter.PlaylistConverter;
import com.example.musicApp.Library.content.dto.converter.SongConverter;
import com.example.musicApp.Library.content.entity.Playlist;
import com.example.musicApp.Library.content.entity.Song;
import com.example.musicApp.Library.content.service.PlaylistService;
import com.example.musicApp.Library.content.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/playlists")
public class PlaylistController {

    private SongService songService;

    private PlaylistService playlistService;

    @Autowired
    PlaylistConverter playlistConverter;


    @Autowired
    public PlaylistController(SongService songService, PlaylistService playlistService) {
        this.playlistService = playlistService;
        this.songService = songService;
    }

    @GetMapping("test")
    public String test() {
        return "test";
    }

    @GetMapping("findAll")
    public List<PlaylistDto> findAll(){
        List<Playlist> playlists = playlistService.findAll();
        return playlistConverter.entityToDto(playlists);
    }

    @GetMapping("find/{ID}")
    public PlaylistDto findById(@PathVariable(value = "ID") Long id){
        Playlist playlist = playlistService.find(id).orElse(null);
        return playlistConverter.entityToDto(playlist);
    }

    @PostMapping("save")
    public PlaylistDto save(@RequestBody PlaylistDto dto){
        Playlist playlist = playlistConverter.dtoToEntity(dto);
        playlistService.create(playlist);
        return playlistConverter.entityToDto(playlist);
    }

    @PutMapping("update/{ID}")
    public void update(@PathVariable(value = "ID") Long id){
        Playlist playlist = playlistService.find(id).orElse(null);
        playlistService.update(playlist);
    }

    @DeleteMapping("delete/{ID}")
    public void delete(@PathVariable(value = "ID") Long id){
        playlistService.delete(id);
    }
}
