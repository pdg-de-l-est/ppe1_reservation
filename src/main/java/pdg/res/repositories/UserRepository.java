package pdg.res.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pdg.res.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByFirstname(String name);
	
}
