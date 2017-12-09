package com.easyenglish.Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Category{
	private int categoryId;
	private String categoryName;
	private int numOfQuestions;
	private int numOfVocab;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getNumOfQuestions() {
		return numOfQuestions;
	}
	public void setNumOfQuestions(int numOfQuestions) {
		this.numOfQuestions = numOfQuestions;
	}
	public int getNumOfVocab() {
		return numOfVocab;
	}
	public void setNumOfVocab(int numOfVocab) {
		this.numOfVocab = numOfVocab;
	}
}

/*
@Entity(name = "category")
public class Category {
	@Id
    @GeneratedValue
    @Column(name = "category_id")
	private int category_id;
	@Column(name = "category_name")
	private String category_name;
	@ManyToMany(mappedBy = "categories")
	private List<SpeakingQuestion> questions;
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public List<SpeakingQuestion> getQuestions() {
		return questions;
	}
	public void setQuestions(List<SpeakingQuestion> questions) {
		this.questions = questions;
	}
}
*/