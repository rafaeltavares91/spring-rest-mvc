package rest.mvc.example.api.v1.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import rest.mvc.example.domain.Customer;
import rest.mvc.example.mapper.v1.CustomerMapper;
import rest.mvc.example.model.v1.CustomerDTO;

public class CustomerMapperTest {

	public static final String FIRSTNAME = "Jimmy";
    public static final String LASTNAME = "Fallon";
    
    private CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Test
    public void customerToCustomerDTO() throws Exception {
        //given
        Customer customer = new Customer();
        customer.setFirstName(FIRSTNAME);
        customer.setLastName(LASTNAME);

        //when
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        //then
        assertEquals(FIRSTNAME, customerDTO.getFirstName());
        assertEquals(LASTNAME, customerDTO.getLastName());
    }
    
}
