package com.project.crud.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.crud.models.Language;

@Service
public class LanguageService {
	// Member variables / service initializations go here
	private List<Language> languages = new ArrayList<Language>(Arrays.asList(
		new Language("Harry Potter and the Sorcerer's Stone", "A boy wizard saving the world", "english"),
		new Language("The Great Gatsby", "The story primarily concerns the young and mysterious millionaire Jay Gatsby", "english"),
		new Language("Moby Dick", "The saga of Captain Ahab", "english"),
		new Language("Don Quixote", "Life of a retired country gentleman", "english"),
		new Language("The Odyssey", "Ancient Greek epic poem", "english")
		));

// returns all the books
public List<Language> allLanguages() {
	return languages;
}
public void addLanguage(Language language) {
	languages.add(language);
}
public Language findLanguageByIndex(int index) {
	if (index < languages.size()){
		return languages.get(index);
	}else{
		return null;
	}
}
public void updateLanguage(int id, Language language) {
	if (id < languages.size()){
		languages.set(id, language);
	}
}
public void destroyLanguage(int id) {
	if (id < languages.size()){
		languages.remove(id);
	}
}

}
