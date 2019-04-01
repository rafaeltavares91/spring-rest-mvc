package rest.mvc.example.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import rest.mvc.example.api.v1.model.CategoryDTO;
import rest.mvc.example.domain.Category;

@Mapper
public interface CategoryMapper {

	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
	
	CategoryDTO categoryToCategoryDTO(Category category);
	
}