package pdg.res.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pdg.res.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	public Product findByTitle(String title);
	
}