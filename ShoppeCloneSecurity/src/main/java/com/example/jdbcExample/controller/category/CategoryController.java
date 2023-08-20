package com.example.jdbcExample.controller.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.jdbcExample.dto.category.CategoryDTO;
import com.example.jdbcExample.service.category.CategoryService;


@Controller
@RequestMapping("admin/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("add")
	public String showAddCategoryPage() {
		return "admin/category/add-category";
	}
	@GetMapping("search")
	public String showSearchCategoryPage() {
		return "admin/category/search-category";
	}
	
	@GetMapping("{categoryId}")
	public String showUpdateCategoryPage(@PathVariable String categoryId, Model model) {
		CategoryDTO categoryDTO = categoryService.getCategoryByCategoryId(Long.parseLong(categoryId));
		model.addAttribute("category", categoryDTO);
		System.out.println(categoryDTO);
		return "admin/category/update-category";
	}
	
	
	

}
