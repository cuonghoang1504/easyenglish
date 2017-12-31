package com.easyenglish.Services;

import java.util.List;

import com.easyenglish.Models.Category;
import com.easyenglish.Models.Vocabulary;

public interface VocabularyService {
	public void addVocab(Vocabulary v);

	public void dropVocabTable();

	public Vocabulary getRandomVocab();

	public List<Vocabulary> getRandomVocabsByCate(List<Category> categories);

	
}
