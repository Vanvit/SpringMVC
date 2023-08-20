package com.example.jdbcExample.service.image;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.jdbcExample.dto.image.ImageDTO;
import com.example.jdbcExample.entity.ImageEntity;
import com.example.jdbcExample.exception.ValidateException;
import com.example.jdbcExample.repository.image.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService{
	@Autowired
	private ImageRepository imageRepository;

	@Override
	public ImageDTO saveImage(MultipartFile file, String description) {
		String fileName = file.getOriginalFilename();
		System.out.println(file);
		//MultipartFile -> File
		try {
			// luu file
			InputStream inputStream = file.getInputStream();
			byte[]	buffer = new byte[inputStream.available()];
			inputStream.read(buffer);
			File newFile = new File("src/main/resources/static/images/"+ fileName);
			OutputStream outputStream = new FileOutputStream(newFile);
			outputStream.write(buffer);
			outputStream.close();
		} catch (IOException e) {
			throw new ValidateException("Server error!");
		} 
		// image Entity
		ImageEntity imageEntity = new ImageEntity();
		imageEntity.setUrl("/images/"+fileName);
		imageEntity.setDescription(description);
		imageRepository.save(imageEntity);
		//convert entity -> dto
		ImageDTO imageDTO = new ImageDTO();
		imageDTO.setDescription(imageEntity.getDescription());
		imageDTO.setUrl(imageEntity.getUrl());
		imageDTO.setImageId(imageEntity.getImageId());
		
		return imageDTO;
	}

}
