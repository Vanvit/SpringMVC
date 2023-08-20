package com.example.jdbcExample.repository.image;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jdbcExample.entity.ImageEntity;

public interface ImageRepository extends JpaRepository<ImageEntity, Long>{

}
