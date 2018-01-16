package com.project.lecture.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.lecture.models.User;

@Repository 												
public interface UserRepoitory extends CrudRepository<User, Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
