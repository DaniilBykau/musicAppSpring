package com.example.musicApp.Library.content.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;


@Getter
@Setter
@NoArgsConstructor
@Log
@SuperBuilder
@Component
@Data
public class Song {
    private Long id;
    private String name;
    private String singer;
    private Integer duration;
}
