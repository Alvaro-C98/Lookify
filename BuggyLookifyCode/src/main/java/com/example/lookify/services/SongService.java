package com.example.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lookify.models.Song;
import com.example.lookify.repositories.SongRepo;

@Service
public class SongService {
	
	@Autowired
	private SongRepo songRepo;
	
	public List<Song> allSongs(){
		return songRepo.findAll();
	}
	
	public Song addSong(Song song) {
		return songRepo.save(song);
	}
	
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepo.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		}else {
			return null;
		}
	}
	
	public List<Song> topTen() {
		return songRepo.getTopTen();
	}
	
	public void deleteSong(Song song) {
		songRepo.delete(song);
	}
	
	public List<Song> artist(String artist){
		return songRepo.findByArtist(artist);
	}
}
