package com.easyenglish.Services;

import com.easyenglish.Models.Answer;

public interface AnswerService {

	void saveAnswer(Answer answer);

	Answer findAnswer(int question_id, int user_id);

}
