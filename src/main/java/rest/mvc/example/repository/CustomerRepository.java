package rest.mvc.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rest.mvc.example.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
