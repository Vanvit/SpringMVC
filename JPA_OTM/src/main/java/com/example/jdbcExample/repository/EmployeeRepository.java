package com.example.jdbcExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.jdbcExample.entity.CompanyEntity;
import com.example.jdbcExample.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>{

	@Query("DELETE FROM EmployeeEntity e where e.company.companyId = :companyId") //HQL
	@Modifying
	void deleteAllByCompanyId(@Param(value="companyId") Long companyId);
}
