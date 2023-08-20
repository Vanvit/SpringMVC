package com.example.jdbcExample.service.category;

import java.util.List;
import java.util.Map;

import com.example.jdbcExample.dto.PageDTO;
import com.example.jdbcExample.dto.category.CategoryDTO;

public interface CategoryService {
	
	public CategoryDTO createCategory(CategoryDTO dto);
	
	//localhost:8080?name=Minh&age=18
	public PageDTO<CategoryDTO> getCategories(Map<String, String> params );
	public CategoryDTO updateCategory(Long categoryId,CategoryDTO dto);
	void deleteCategory(Long categoryId);

	public CategoryDTO getCategoryByCategoryId(long categoryId);
	

}
