package com.example.jdbcExample.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class CompanyEntity {
	@Id // primary key
	@Column(name="companyId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long companyId;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "company"/*,cascade=CascadeType.REMOVE*/)
	private List<EmployeeEntity> employees = new ArrayList<EmployeeEntity>();
	
	
	public void addEmployee(EmployeeEntity employeeEntity) {
		employees.add(employeeEntity);
		employeeEntity.setCompany(this);
	}
	
	

	public List<EmployeeEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeEntity> employees) {
		this.employees = employees;
	}

	public CompanyEntity() {
		super();
	}

	public CompanyEntity(Long companyId, String name) {
		super();
		this.companyId = companyId;
		this.name = name;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CompanyEntity [companyId=" + companyId + ", name=" + name + "]";
	}
	
	
	

}
