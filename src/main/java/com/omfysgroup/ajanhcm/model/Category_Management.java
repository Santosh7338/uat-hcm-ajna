package com.omfysgroup.ajanhcm.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORY_MAPPING")
public class Category_Management {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_mapping_seq")
	@SequenceGenerator(name = "category_mapping_seq", sequenceName = "CATEGORY_MAPPING_SEQ", allocationSize = 1)

	@Column(name = "CATEGORY_ID")
	private int category_id;
	
	@Column(name = "CATEGORY_NAME")
	private String categoryName;

	@Column(name = "SUB_CATEGORY_NAME")
	private String subCategoryName;

	@Column(name = "SUB_SUB_CATEGORY_NAME")
	private String subSubCategoryName;
	
	@Column(name = "MODULE")
	private String module;
	
	
	//@Column(name = "MAIL_CONTENT")
	//private String mailContent;

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public String getSubSubCategoryName() {
		return subSubCategoryName;
	}

	public void setSubSubCategoryName(String subSubCategoryName) {
		this.subSubCategoryName = subSubCategoryName;
	}
	

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	@Override
	public String toString() {
		return "Category_Management [category_id=" + category_id + ", categoryName=" + categoryName
				+ ", subCategoryName=" + subCategoryName + ", subSubCategoryName=" + subSubCategoryName + ", module="
				+ module + "]";
	}




	
	//public String getMailContent() {
		//return mailContent;
	//}

	//public void setMailContent(String mailContent) {
	//	this.mailContent = mailContent;
	//}

	

	
	
	
	
}
