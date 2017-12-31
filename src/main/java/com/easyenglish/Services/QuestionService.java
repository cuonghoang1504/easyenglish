package com.easyenglish.Services;

import com.easyenglish.Models.Question;

public interface QuestionService {

	void addQuestion(Question q);

	Question getRandomSpeakingQuestion();

	Question getRandomWritingQuestion();

}
