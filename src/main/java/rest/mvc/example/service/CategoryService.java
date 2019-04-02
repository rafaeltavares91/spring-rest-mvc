package rest.mvc.example.service;

import java.util.List;

import rest.mvc.example.api.v1.model.CategoryDTO;

public interface CategoryService {

	List<CategoryDTO> getAllCategories();
	
	CategoryDTO getCategoryByName(String name);

}