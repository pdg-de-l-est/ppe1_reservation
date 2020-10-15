package pdg.res.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pdg.res.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

	public Reservation findById(int id);
	
}
