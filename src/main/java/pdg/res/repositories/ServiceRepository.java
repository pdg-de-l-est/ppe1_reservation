package pdg.res.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pdg.res.models.Service;

public interface ServiceRepository extends JpaRepository<Service, Integer> {

	public Service findByName(String name);
	
}
