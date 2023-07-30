package com.example.jdbcExample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.jdbcExample.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{

	@Query("Select r from RoleEntity r where r.code=:code")
	Optional<RoleEntity> findByCode(@Param(value="code") String code);
}
