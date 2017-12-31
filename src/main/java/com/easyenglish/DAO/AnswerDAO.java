package com.easyenglish.DAO;

import com.easyenglish.Models.Answer;

public interface AnswerDAO {

	void saveAnswer(Answer answer);

	Answer findAnswer(int question_id, int user_id);

}
