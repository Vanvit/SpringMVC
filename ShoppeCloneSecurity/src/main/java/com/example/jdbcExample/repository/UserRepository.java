package com.example.jdbcExample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.jdbcExample.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

	@Query("Select u from UserEntity u where u.username=:username")
	Optional<UserEntity> findByUsername(@Param(value="username") String username);
}
