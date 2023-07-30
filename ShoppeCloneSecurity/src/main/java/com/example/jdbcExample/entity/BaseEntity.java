package com.example.jdbcExample.entity;

import java.sql.Date;

import javax.persistence.MappedSuperclass;

@MappedSuperclass

public class BaseEntity {
	
	private Date createDate;
	private Date modifierDate;
	private Date createBy;
	private Date modifierBy;
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
	public Date getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Date createBy) {
		this.createBy = createBy;
	}
	public Date getModifierBy() {
		return modifierBy;
	}
	public void setModifierBy(Date modifierBy) {
		this.modifierBy = modifierBy;
	}
	

}
