package rest.mvc.example.model.v1;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerListDTO {

	private List<CustomerDTO> customers;
	
}