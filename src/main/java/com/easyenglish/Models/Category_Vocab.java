package com.easyenglish.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "category_vocab")
public class Category_Vocab {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "category_id")
	private int category_id;
	@Column(name = "vocab_id")
	private int vocab_id;
}
