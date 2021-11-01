package com.example.musicApp.Library.content.dto.converter;

import com.example.musicApp.Library.content.dto.SongDto;
import com.example.musicApp.Library.content.entity.Playlist;
import com.example.musicApp.Library.content.entity.Song;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Component
public class SongConverter {



    public SongDto entityToDto(Song song){
        SongDto dto = new SongDto();
        dto.setId(song.getId());
        dto.setName(song.getName());
        dto.setSinger(song.getSinger());
        dto.setPlaylist(song.getPlaylist().getName());
        return  dto;
    }

    public SongDto entityToDtoCreateAndUpdate(Song song){
        SongDto dto = new SongDto();
        dto.setName(song.getName());
        dto.setSinger(song.getSinger());
        return  dto;
    }

    public Song dtoToEntity(SongDto dto) {
        ModelMapper modelMapper = new ModelMapper();
        Song song = modelMapper.map(SongDto.class, Song.class);
        return song;
    }

    public Song dtoToEntityCreateAndUpdate(SongDto dto){
        Song song = new Song();
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



    public Function<SongDto, Song> dtoToEntityCreate(
            Supplier<Playlist> playlistSupplier) {
        return request -> Song.builder()
                .name(request.getName())
                .singer(request.getSinger())
                .id(request.getId())
                .playlist(playlistSupplier.get())
                .build();
    }

}
