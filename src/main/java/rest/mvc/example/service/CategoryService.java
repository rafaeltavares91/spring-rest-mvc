package rest.mvc.example.service;

import java.util.List;

import rest.mvc.example.model.v1.CategoryDTO;

public interface CategoryService {

	List<CategoryDTO> getAllCategories();
	
	CategoryDTO getCategoryByName(String name);

}