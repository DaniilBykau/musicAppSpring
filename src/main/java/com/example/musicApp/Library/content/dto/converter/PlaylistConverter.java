package com.example.musicApp.Library.content.dto.converter;

import com.example.musicApp.Library.content.dto.PlaylistDto;
import com.example.musicApp.Library.content.dto.SongDto;
import com.example.musicApp.Library.content.entity.Playlist;
import com.example.musicApp.Library.content.entity.Song;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlaylistConverter {

    public PlaylistDto entityToDto(Playlist playlist){
        PlaylistDto dto = new PlaylistDto();
        dto.setId(playlist.getId());
        dto.setName(playlist.getName());
        return  dto;
    }

    public Playlist dtoToEntity(PlaylistDto dto){
        Playlist playlist = new Playlist();
        playlist.setId(dto.getId());
        playlist.setName(dto.getName());
        return playlist;
    }

    public List<PlaylistDto> entityToDto(List<Playlist> playlists){
        return playlists.stream().map(x->entityToDto(x)).collect(Collectors.toList());
    }

    public List<Playlist> dtoToEntity(List<PlaylistDto> dtos){
        return dtos.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
