package pdg.res.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pdg.res.models.Caracteristic;

public interface CaracteristicRepository extends JpaRepository<Caracteristic, Integer> {

	public Caracteristic findByLabel(String label);
	
}
