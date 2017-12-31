package com.easyenglish.DAO;

import java.util.List;

import com.easyenglish.Models.Category;
import com.easyenglish.Models.Vocabulary;

public interface VocabularyDAO {
	public void addVocablulary(Vocabulary v);

	public void dropVocabTable();

	public Vocabulary getRandomVocab();

	public List<Vocabulary> getRandomVocabsByCate(List<Category> categories);
	
	public boolean isVocabExisted(Vocabulary v);
}
