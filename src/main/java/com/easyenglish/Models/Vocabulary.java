package com.easyenglish.Models;

import java.util.List;

import javax.persistence.*;

@Entity(name = "vocabulary")
public class Vocabulary {
	@Id
	@GeneratedValue
	@Column(name = "vocab_id")
	private int vocab_id;
	@Column(name = "vocab")
	private String vocab;
	@Column(name = "meaning")
	private String meaning;
	@Column(name = "example")
	private String example;
	@JoinTable(name = "Category_Vocab", joinColumns = { @JoinColumn(name = "vocab_id") }, inverseJoinColumns = { @JoinColumn(name = "category_id") })
	@ManyToMany
	private List<Category> categories;
	
	
	public String getVocab() {
		return vocab;
	}
	public void setVocab(String vocab) {
		this.vocab = vocab;
	}
	public int getVocab_id() {
		return vocab_id;
	}
	public void setVocab_id(int vocab_id) {
		this.vocab_id = vocab_id;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	public String getExample() {
		return example;
	}
	public void setExample(String example) {
		this.example = example;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}
