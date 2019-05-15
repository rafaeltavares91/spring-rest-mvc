package rest.mvc.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CustomerDTO {

	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String password;
	
	@JsonProperty("customer_url")
	private String url;
	
}
