package rest.mvc.example.api.v1.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import rest.mvc.example.api.v1.model.CategoryDTO;
import rest.mvc.example.service.CategoryService;

public class CategoryControllerTest {

	public static final String NAME = "Jim";

	@Mock
	private CategoryService categoryService;

	@InjectMocks
	private CategoryController categoryController;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
	}

	@Test
	public void testListCategories() throws Exception {
		CategoryDTO category1 = new CategoryDTO();
		category1.setId(1l);
		category1.setName(NAME);

		CategoryDTO category2 = new CategoryDTO();
		category2.setId(2l);
		category2.setName("Bob");

		List<CategoryDTO> categories = Arrays.asList(category1, category2);

		when(categoryService.getAllCategories()).thenReturn(categories);

		mockMvc.perform(get(CategoryController.BASE_URL)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.categories", hasSize(2)));
	}

	@Test
	public void testGetByNameCategories() throws Exception {
		CategoryDTO category1 = new CategoryDTO();
		category1.setId(1l);
		category1.setName(NAME);

		when(categoryService.getCategoryByName(anyString())).thenReturn(category1);

		mockMvc.perform(get(CategoryController.BASE_URL.concat("Jim"))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", equalTo(NAME)));
	}
}
