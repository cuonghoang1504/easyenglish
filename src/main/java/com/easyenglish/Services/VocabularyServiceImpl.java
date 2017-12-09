package com.easyenglish.Services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyenglish.DAO.CategoryDAO;
import com.easyenglish.DAO.VocabularyDAO;
import com.easyenglish.Models.Vocabulary;
@Service
public class VocabularyServiceImpl implements VocabularyService{
	private VocabularyDAO vocabularyDAO;

	public void setVocabularyDAO(VocabularyDAO vocabularyDAO) {
		this.vocabularyDAO = vocabularyDAO;
	}

	@Transactional
	public void addVocab(Vocabulary v) {
		
		this.vocabularyDAO.addVocablulary(v);
	}

}
