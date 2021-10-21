package com.example.musicApp.Library.content.dto.converter;

import com.example.musicApp.Library.content.dto.SongDto;
import com.example.musicApp.Library.content.entity.Song;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SongConverter {

    public SongDto entityToDto(Song song){
        SongDto dto = new SongDto();
        dto.setId(song.getId());
        dto.setName(song.getName());
        dto.setSinger(song.getSinger());
        return  dto;
    }

    public Song dtoToEntity(SongDto dto){
        Song song = new Song();
        song.setId(dto.getId());
        song.setName(dto.getName());
        song.setSinger(dto.getSinger());

        return song;
    }

    public List<SongDto> entityToDto(List<Song> songs){
        return songs.stream().map(x->entityToDto(x)).collect(Collectors.toList());
    }

    public List<Song> dtoToEntity(List<SongDto> dtos){
        return dtos.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }

}
