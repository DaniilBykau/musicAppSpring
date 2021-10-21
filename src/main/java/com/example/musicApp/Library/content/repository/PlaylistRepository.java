package com.example.musicApp.Library.content.repository;

import com.example.musicApp.Library.content.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {


    Optional<Playlist> findById(Long id);

    List<Playlist> findAll();

}
