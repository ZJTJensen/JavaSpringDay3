package com.project.songs.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SongService {
	// Member variables / service initializations go here

	private SongRepository songRepository;
    public SongService(SongRepository songRepository){
        this.songRepository = songRepository;
    }
		
	public SongService(){

	}
	
	// Crud methods to act on services go here.
	public List<Song> allSongs(){
        return songRepository.findAll();
    }
    public void addSong(Song song){
        songRepository.save(song);
	}
	public void destroySong(Long id) {
        songRepository.delete(id);
	}
	public Song findSongById(Long id) {
        return songRepository.findOne(id);
	}
	public void updateSong(Song song) {
        songRepository.save(song);
	}
	
	public List<Song> getTopTen(){
		List<Song> topTenList = _sr.OrderByRatingDesc();
		topTenList.subList(10, topTenList.size()).clear();
		return topTenList;
	}
	public List<Song> searchByArtist(String search){
		return _sr.findByArtistContaining(search);
	}
}
