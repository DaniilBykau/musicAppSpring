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


    @GetMapping
    public List<PlaylistDto> findAll(){
        List<Playlist> playlists = playlistService.findAll();
        return playlistConverter.entityToDto(playlists);
    }

    @GetMapping("{ID}")
    public PlaylistDto findById(@PathVariable(value = "ID") Long id){
        Playlist playlist = playlistService.find(id).orElse(null);
        return playlistConverter.entityToDto(playlist);
    }

    @PostMapping
    public PlaylistDto save(@RequestBody PlaylistDto dto){
        Playlist playlist = playlistConverter.dtoToEntityUpdateAndCreate(dto);
        playlistService.create(playlist);
        return playlistConverter.entityToDtoCreateAndUpdate(playlist);
    }

    @PutMapping("{ID}")
    public PlaylistDto update(@PathVariable(value = "ID") Long id, @RequestBody Playlist newPlaylist){
        Playlist playlist = playlistService.find(id).orElse(null);
        playlist = playlistService.update(playlist, newPlaylist);
        return playlistConverter.entityToDtoCreateAndUpdate(playlist);
    }

    @DeleteMapping("{ID}")
    public void delete(@PathVariable(value = "ID") Long id){
        playlistService.delete(id);
    }
}
