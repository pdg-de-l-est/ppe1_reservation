package pdg.res.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pdg.res.models.Location;

public interface LocationRepository extends JpaRepository<Location, Integer>{
	
	public Location findById(int id);

}
