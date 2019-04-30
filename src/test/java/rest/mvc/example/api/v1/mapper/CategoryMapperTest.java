package rest.mvc.example.api.v1.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import rest.mvc.example.domain.Category;
import rest.mvc.example.mapper.v1.CategoryMapper;
import rest.mvc.example.model.v1.CategoryDTO;

public class CategoryMapperTest {

	private static final long ID = 1L;
	private static final String NAME = "Rafa";
	
	private CategoryMapper categoryMapper = CategoryMapper.INSTANCE;
	
	@Test
	public void categoryToCateryDTO() throws Exception {
		Category category = new Category();
		category.setId(ID);
		category.setName(NAME);
		
		CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);
		
		assertEquals(Long.valueOf(ID), categoryDTO.getId());
		assertEquals(NAME, categoryDTO.getName());
	}
}