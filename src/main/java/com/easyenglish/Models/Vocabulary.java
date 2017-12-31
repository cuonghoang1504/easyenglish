package com.easyenglish.Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Type;

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
	
	@Type(type = "org.hibernate.type.NumericBooleanType")
	@Column(columnDefinition = "TINYINT", name = "verb")
	private boolean verb;
	
	@Column(columnDefinition = "TINYINT",name = "noun")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean noun;
	@Column(columnDefinition = "TINYINT",name = "adj")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean adj;
	@Column(columnDefinition = "TINYINT",name = "adv")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean adv;
	
	@Column(name = "synonyms")
	private String synonyms;
	
	
	
	public String getSynonyms() {
		return synonyms;
	}
	public void setSynonyms(String synonyms) {
		this.synonyms = synonyms;
	}
	public boolean isVerb() {
		return verb;
	}
	public void setVerb(boolean verb) {
		this.verb = verb;
	}
	public boolean isNoun() {
		return noun;
	}
	public void setNoun(boolean noun) {
		this.noun = noun;
	}
	public boolean isAdj() {
		return adj;
	}
	public void setAdj(boolean adj) {
		this.adj = adj;
	}
	public boolean isAdv() {
		return adv;
	}
	public void setAdv(boolean adv) {
		this.adv = adv;
	}
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
