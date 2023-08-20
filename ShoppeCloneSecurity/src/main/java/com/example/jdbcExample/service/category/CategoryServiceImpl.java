package com.example.jdbcExample.service.category;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jdbcExample.converter.category.CategoryConverter;
import com.example.jdbcExample.dto.PageDTO;
import com.example.jdbcExample.dto.category.CategoryDTO;
import com.example.jdbcExample.entity.CategoryEntity;
import com.example.jdbcExample.exception.ValidateException;
import com.example.jdbcExample.repository.category.CategoryRepository;
import com.example.jdbcExample.utils.AppStringUtils;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private  CategoryConverter categoryConverter;
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public CategoryDTO createCategory(CategoryDTO dto) {
		// validate
		String name = dto.getName();
		if(!AppStringUtils.hasText(name)) {
			throw new ValidateException("category name can not empty!");
		}
		// converter dto -> entity
		CategoryEntity newCategoryEntity = categoryConverter.toEntity(dto);
		categoryRepository.save(newCategoryEntity);
		// converter entity -> dto
		CategoryDTO resultDto = categoryConverter.toDTO(newCategoryEntity);
		
		return resultDto;
	}

	@Override
	public CategoryDTO updateCategory(Long categoryId, CategoryDTO dto) {
		
		CategoryEntity categoryEntity = categoryRepository.findById(categoryId).orElseThrow(
				()-> new ValidateException("Category Not Found!"));
		
		// dto -> entity
		categoryConverter.toEntity(categoryEntity, dto);
		categoryRepository.save(categoryEntity);
		
		return categoryConverter.toDTO(categoryEntity);
	}
	@Override
	public void deleteCategory(Long categoryId) {
		//validate
		categoryRepository.findById(categoryId).orElseThrow(
				()-> new ValidateException("Category Not Found!"));
		
		categoryRepository.deleteById(categoryId);
		
	}

	@Override
	public PageDTO<CategoryDTO> getCategories(Map<String, String> params) {
		
		//http://localhost:8080/admin/api/v1/categories?page=1&limit=2
		System.out.println(params);
		String pageStr = params.get("page");
		String limitStr = params.get("limit");
		
		Integer page=1;
		Integer limit = 10;
		
		if(AppStringUtils.hasText(pageStr)) {
			page = Integer.valueOf(pageStr); // convert String -> Integer
		}
		if(AppStringUtils.hasText(limitStr)) {
			limit = Integer.valueOf(limitStr);
		}
		
		//lay data
		// dem data
		StringBuilder selectQueryBuilder =new  StringBuilder("Select c from CategoryEntity c"); 
		StringBuilder countQueryBuilder = new StringBuilder("Select count(c.categoryId) "
				+ "from CategoryEntity c");
		
		String name = params.get("name");
		if(AppStringUtils.hasText(name)){
			selectQueryBuilder.append(" Where c.name LIKE :name");
			countQueryBuilder.append(" Where c.name LIKE :name");
		}
		
		TypedQuery<CategoryEntity> selectQuery =
				entityManager.createQuery(selectQueryBuilder.toString(), CategoryEntity.class);
		TypedQuery<Long> countQuery =
				entityManager.createQuery(countQueryBuilder.toString(), Long.class);
		
		Integer firstItems = (page-1) * limit;
		
		if(AppStringUtils.hasText(name)){
			selectQuery.setParameter("name","%"+name+"%");
			countQuery.setParameter("name", "%"+name+"%");
		}
		
		selectQuery.setFirstResult(firstItems);
		selectQuery.setMaxResults(limit);
		
		List<CategoryEntity> categoryEntities = selectQuery.getResultList();
		Long totalItems= countQuery.getSingleResult();
		
		//entity -> dto
		List<CategoryDTO> dtos = categoryConverter.toDTOList(categoryEntities);
		
	
		return new PageDTO<>(page, limit, totalItems, dtos);
	}

	@Override
	public CategoryDTO getCategoryByCategoryId(long categoryId) {
		CategoryEntity categoryEntity = categoryRepository.findById(categoryId)
				.orElseThrow(()-> new ValidateException("Không tìm thấy danh mục"));
		
		return categoryConverter.toDTO(categoryEntity);
	}
}
