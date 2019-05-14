package rest.mvc.example.service;

import java.util.List;

import rest.mvc.example.model.CategoryDTO;

public interface CategoryService {

	List<CategoryDTO> getAllCategories();
	
	CategoryDTO getCategoryByName(String name);

}