package pdg.res.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pdg.res.models.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Integer>{

	public Photo findById(int id);
}
