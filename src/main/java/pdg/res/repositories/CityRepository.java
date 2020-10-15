package pdg.res.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pdg.res.models.City;

public interface CityRepository extends JpaRepository<City, Integer> {
	
	public City findByName(String name);

}
