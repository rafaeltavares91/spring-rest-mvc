package rest.mvc.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import rest.mvc.example.controller.CustomerController;
import rest.mvc.example.domain.Customer;
import rest.mvc.example.exception.ResourceNotFoundException;
import rest.mvc.example.mapper.CustomerMapper;
import rest.mvc.example.model.CustomerDTO;
import rest.mvc.example.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerMapper customerMapper;
	private final CustomerRepository customerRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	
	public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository, BCryptPasswordEncoder passwordEncoder) {
		this.customerMapper = customerMapper;
		this.customerRepository = customerRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public List<CustomerDTO> getAllCustomers() {
		return customerRepository.findAll()
				.stream()
				.map(customer -> {
					CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
					customerDTO.setUrl(CustomerController.BASE_URL + customer.getId());
					return customerDTO;
				})
				.collect(Collectors.toList());
	}
	
	@Override
	public CustomerDTO getCustomerById(Long id) {
		CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(
				customerRepository.findById(id).orElseThrow(ResourceNotFoundException::new));
		customerDTO.setUrl(CustomerController.BASE_URL + id);
		return customerDTO;
	}
	
	@Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
		customerDTO.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
        return saveAndReturnDTO(customerMapper.customerDTOToCustomer(customerDTO));
    }

    private CustomerDTO saveAndReturnDTO(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        CustomerDTO returnDto = customerMapper.customerToCustomerDTO(savedCustomer);
        returnDto.setUrl(CustomerController.BASE_URL + savedCustomer.getId());
        return returnDto;
    }

    @Override
    public CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        customer.setId(id);
        return saveAndReturnDTO(customer);
    }
    
    @Override
    public CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO) {
        return customerRepository.findById(id).map(customer -> {
            if(customerDTO.getFirstName() != null){
                customer.setFirstName(customerDTO.getFirstName());
            }
            if(customerDTO.getLastName() != null){
                customer.setLastName(customerDTO.getLastName());
            }
            CustomerDTO returnDto = customerMapper.customerToCustomerDTO(customerRepository.save(customer));
            returnDto.setUrl(CustomerController.BASE_URL + id);
            return returnDto;
        }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

}
