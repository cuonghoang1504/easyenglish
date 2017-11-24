package com.easyenglish.Models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "question_category")
public class question_category {
	@Column(name = "question_id")
	private int question_id;
	@Column(name = "category_id")
	private int category_id;
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
}
