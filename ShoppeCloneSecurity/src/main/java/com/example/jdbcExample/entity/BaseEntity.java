package com.example.jdbcExample.entity;


import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifierDate;
	@CreatedBy
	private String createBy;
	@LastModifiedBy
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
	
	

}
