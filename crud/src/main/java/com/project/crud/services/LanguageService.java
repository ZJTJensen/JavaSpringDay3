package com.project.crud.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.crud.models.Language;
import com.project.crud.repositories.LanguageRepository;

@Service
public class LanguageService {



	private LanguageRepository languageRepository;
    public LanguageService(LanguageRepository languageRepository){
        this.languageRepository = languageRepository;
	}
	

	// Member variables / service initializations go here
	private List<Language> languages = new ArrayList<Language>(Arrays.asList());

// returns all the books
public List<Language> allLanguages() {
	return languageRepository.findAll();
}
public void addLanguage(Language language) {
	languageRepository.save(language);
}



public Language findLanguageByIndex(Long id) {
	return languageRepository.findOne(id);
}
public void updateLanguage(Language language) {
	languageRepository.save(language);
}
public void destroyLanguage(Long id) {
	languageRepository.delete(id);
}

}
