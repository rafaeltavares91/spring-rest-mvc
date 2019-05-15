package rest.mvc.example.boostrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import rest.mvc.example.domain.Category;
import rest.mvc.example.domain.Customer;
import rest.mvc.example.repository.CategoryRepository;
import rest.mvc.example.repository.CustomerRepository;

@Component
public class Bootstrap implements CommandLineRunner {

	private CategoryRepository categoryRepository;
	private CustomerRepository customerRepository;
	
	public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
		this.categoryRepository = categoryRepository;
		this.customerRepository = customerRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		loadCategories();
		loadCustomers();
	}

	private void loadCategories() {
		Category fruits = new Category();
		fruits.setName("Fruits");
		
		Category dried = new Category();
		dried.setName("Dried");
		
		Category fresh = new Category();
		fresh.setName("Fresh");
		
		Category exotic = new Category();
		exotic.setName("Exotic");
		
		Category nuts = new Category();
		nuts.setName("Nuts");
		
		categoryRepository.save(fruits);
		categoryRepository.save(dried);
		categoryRepository.save(fresh);
		categoryRepository.save(exotic);
		categoryRepository.save(nuts);
		
		System.out.println("Categories loaded: " + categoryRepository.count());
	}
	
	private void loadCustomers() {
		Customer rafael = new Customer();
		rafael.setFirstName("Rafael");
		rafael.setLastName("Tavares");
		rafael.setPassword("123456");
		
		Customer miguel = new Customer();
		miguel.setFirstName("Miguel");
		miguel.setLastName("Souza");
		rafael.setPassword("123456");
		
		customerRepository.save(rafael);
		customerRepository.save(miguel);
		
		System.out.println("Customers loaded: " + customerRepository.count());
	}

}
