package com.example.musicApp.Library.content.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Log
@SuperBuilder
@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String singer;

    private Integer duration;
}
