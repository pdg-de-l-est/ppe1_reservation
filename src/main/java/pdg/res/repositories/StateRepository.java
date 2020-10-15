package pdg.res.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pdg.res.models.State;

public interface StateRepository extends JpaRepository<State, Integer>{
	
	public State findByName(String name);

}
