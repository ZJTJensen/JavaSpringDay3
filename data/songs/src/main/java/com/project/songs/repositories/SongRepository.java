package com.project.songs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface SongRepository extends CrudRepository<Song,Long>{
	// Query methods go here.
	List<Song> findAll();
	List<Song> OrderByRatingDesc();
	List<Song> findByArtistContaining(String search);
	
	// Example:
	// public YourModelHere findByName(String name);
}
