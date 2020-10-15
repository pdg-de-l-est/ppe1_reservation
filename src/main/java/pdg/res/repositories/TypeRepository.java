package pdg.res.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pdg.res.models.Type;

public interface TypeRepository extends JpaRepository<Type, Integer> {
	
	public Type findByLibelle(String libelle);

}
