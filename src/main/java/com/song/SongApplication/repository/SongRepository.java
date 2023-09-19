package com.song.SongApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.song.SongApplication.model.Song;


@Repository

public interface SongRepository extends JpaRepository<Song,Long> {

}
