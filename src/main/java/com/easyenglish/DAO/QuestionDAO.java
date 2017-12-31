package com.easyenglish.DAO;

import com.easyenglish.Models.Question;

public interface QuestionDAO {
	public void addQuestion(Question q);

	public Question getRandomSpeakingQuestion();

	public Question getRandomWritingQuestion();
	
	public boolean isQuestionExisted(Question q);
}
