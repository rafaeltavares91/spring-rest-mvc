package rest.mvc.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import rest.mvc.example.api.v1.mapper.CategoryMapper;
import rest.mvc.example.api.v1.model.CategoryDTO;
import rest.mvc.example.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryMapper categoryMapperImpl;
	private final CategoryRepository categoryRepository;
	
	public CategoryServiceImpl(CategoryMapper categoryMapperImpl, CategoryRepository categoryRepository) {
		this.categoryMapperImpl = categoryMapperImpl;
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public List<CategoryDTO> getAllCategories() {
		return categoryRepository.findAll()
				.stream()
				.map(categoryMapperImpl::categoryToCategoryDTO)
				.collect(Collectors.toList());
	}
	
	@Override
	public CategoryDTO getCategoryByName(String name) {
		return categoryMapperImpl.categoryToCategoryDTO(categoryRepository.findByName(name));
	}
	
}