package pdg.res.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pdg.res.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	public Optional<Product> findByTitle(String title);
	public List<Product> findByType(String type);
}
