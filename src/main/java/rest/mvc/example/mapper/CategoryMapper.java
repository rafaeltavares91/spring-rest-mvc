package rest.mvc.example.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import rest.mvc.example.domain.Category;
import rest.mvc.example.model.CategoryDTO;

@Mapper
public interface CategoryMapper {

	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
	
	CategoryDTO categoryToCategoryDTO(Category category);
	
}