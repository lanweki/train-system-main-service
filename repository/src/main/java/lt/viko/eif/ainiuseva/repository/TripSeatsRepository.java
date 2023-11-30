package lt.viko.eif.ainiuseva.repository;

import lt.viko.eif.ainiuseva.model.TripSeats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripSeatsRepository extends JpaRepository<TripSeats, Integer> {
}
