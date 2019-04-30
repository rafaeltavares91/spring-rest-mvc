package rest.mvc.example.mapper.v1;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import rest.mvc.example.domain.Customer;
import rest.mvc.example.model.v1.CustomerDTO;

@Mapper
public interface CustomerMapper {

	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
	
	CustomerDTO customerToCustomerDTO(Customer customer);
	
	Customer customerDtoToCustomer(CustomerDTO customerDTO);
	
}