package com.example.musicApp.Library.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<Entity, Key> {

    Optional<Entity> find(Key id);

    List<Entity> findAll();

    void create(Entity entity);

    void delete(Entity entity);
}
