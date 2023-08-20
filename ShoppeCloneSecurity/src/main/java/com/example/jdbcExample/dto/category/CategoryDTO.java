package com.example.jdbcExample.dto.category;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CategoryDTO {
	private Long categoryId;
	private String name;
	private String description;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifierDate;
	
	private String createBy;
	private String modifierBy;
	
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifierDate() {
		return modifierDate;
	}
	public void setModifierDate(Date modifierDate) {
		this.modifierDate = modifierDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getModifierBy() {
		return modifierBy;
	}
	public void setModifierBy(String modifierBy) {
		this.modifierBy = modifierBy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	

}
