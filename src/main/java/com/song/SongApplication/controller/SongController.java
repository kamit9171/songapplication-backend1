package com.song.SongApplication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.song.SongApplication.exception.ResourceNotFoundException;
import com.song.SongApplication.model.Song;
import com.song.SongApplication.repository.SongRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class SongController {
	//hello
	@Autowired
	private SongRepository songRepository;
	
	@GetMapping("/song")
	public List<Song> getAllSong()
	{
		return songRepository.findAll();
	}
	
	//create a song rest api
	
	@PostMapping("/song")
	public Song createSong(@RequestBody Song song)
	{
		return songRepository.save(song);
	}
	
	//get song by id rest api
	
	@GetMapping("/song/{id}")
	public ResponseEntity<Song> getSongById(@PathVariable Long id)
	{
		Song song = songRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Song Not Exist with this Particular Id"+ id));
		return ResponseEntity.ok(song);
	}
	
	//update a song details rest api
	
	@PutMapping("/song/{id}")
	public ResponseEntity<Song> updateSong(@PathVariable Long id,@RequestBody Song songDetails)
	{
		Song song =songRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Song not exist with id :"+ id));
		
		song.setSongName(songDetails.getSongName());
		song.setSingerName(songDetails.getSingerName());
		song.setAlbumName(songDetails.getAlbumName());
	
		
		Song updatedSong = songRepository.save(song);
		
		
		return ResponseEntity.ok(updatedSong);
		
	}

	//delete song rest api
	@DeleteMapping("/song/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteSong (@PathVariable Long id){
		Song song =songRepository.findById(id) .orElseThrow(()-> new ResourceNotFoundException("Song Not exist with id"+id));
		
		songRepository.delete(song);
		Map<String,Boolean> response =new HashMap<> ();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
