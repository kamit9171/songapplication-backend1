package com.song.SongApplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Playlist")
public class Song {
	

	

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)

	
	private long id;
	
	@Column(name ="Song_Name")
	private String songName;
	
	@Column(name ="Singer_Name")
	private String singerName;
	
	@Column(name="Album_Name")
	private String albumName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	
	
	
	
	
	
	
}
