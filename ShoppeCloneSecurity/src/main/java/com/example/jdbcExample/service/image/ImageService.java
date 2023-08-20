package com.example.jdbcExample.service.image;

import org.springframework.web.multipart.MultipartFile;

import com.example.jdbcExample.dto.image.ImageDTO;

public interface ImageService {
	ImageDTO saveImage(MultipartFile file, String description);

}
