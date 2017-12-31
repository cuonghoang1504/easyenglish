package com.easyenglish.Services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.easyenglish.DAO.AnswerDAO;
import com.easyenglish.DAO.CategoryDAO;
import com.easyenglish.Models.Answer;

@Service
public class AnswerServiceImpl implements AnswerService{
	private AnswerDAO answerDAO;

	public void setAnswerDAO(AnswerDAO answerDAO) {
		this.answerDAO = answerDAO;
	}

	@Transactional
	public void saveAnswer(Answer answer) {
		this.answerDAO.saveAnswer(answer);
		
	}

	@Transactional
	public Answer findAnswer(int question_id, int user_id) {
		// TODO Auto-generated method stub
		return this.answerDAO.findAnswer(question_id, user_id);
	}
}
