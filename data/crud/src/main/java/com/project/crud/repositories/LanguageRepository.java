package com.project.crud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.crud.models.Language;

@Repository 												
public interface LanguageRepository extends CrudRepository<Language,Long>{
	// Query methods go here.
	List<Language> findAll();
	// Example:
	// public YourModelHere findByName(String name);
}
