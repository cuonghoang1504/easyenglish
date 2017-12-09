package com.easyenglish.Services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.easyenglish.DAO.QuestionDAO;
import com.easyenglish.Models.Question;
@Service
public class QuestionServiceImpl implements QuestionService{
	private QuestionDAO questionDAO;

	public void setQuestionDAO(QuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}

	@Override
	@Transactional
	public void addQuestion(Question q) {
		this.questionDAO.addQuestion(q);
		
	}

	@Override
	@Transactional
	public Question getRandomSpeakingQuestion() {
		// TODO Auto-generated method stub
		return this.questionDAO.getRandomSpeakingQuestion();
	}
}
