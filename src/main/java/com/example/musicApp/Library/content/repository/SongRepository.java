package com.example.musicApp.Library.content.repository;


import com.example.musicApp.Library.content.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;


public interface SongRepository extends JpaRepository<Song, Long> {

    Optional<Song> findById(Long id);

    List<Song> findAll();
}
