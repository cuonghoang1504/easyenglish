package com.easyenglish.Models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "SpeakingQuestion")
public class SpeakingQuestion {
	@Id
	@Column(name ="question_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int question_id;
	@Column(name = "question")
	private String question;
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "question_category",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
	private List<Category> categories;
	@Column(name = "level")
	private int level;
	@Column(name = "hint1")
	private String hint1;
	@Column(name = "hint2")
	private String hint2;
	@Column(name = "hint3")
	private String hint3;
	@Column(name = "modelAnswer")
	private String modelAnswer;
	
	public String getHint1() {
		return hint1;
	}
	public void setHint1(String hint1) {
		this.hint1 = hint1;
	}
	public String getHint2() {
		return hint2;
	}
	public void setHint2(String hint2) {
		this.hint2 = hint2;
	}
	public String getHint3() {
		return hint3;
	}
	public void setHint3(String hint3) {
		this.hint3 = hint3;
	}
	public String getModelAnswer() {
		return modelAnswer;
	}
	public void setModelAnswer(String modelAnswer) {
		this.modelAnswer = modelAnswer;
	}
	
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
