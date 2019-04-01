package rest.mvc.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rest.mvc.example.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
