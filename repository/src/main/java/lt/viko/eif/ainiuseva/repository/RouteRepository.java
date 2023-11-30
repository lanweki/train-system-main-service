package lt.viko.eif.ainiuseva.repository;

import lt.viko.eif.ainiuseva.model.Route;
import lt.viko.eif.ainiuseva.model.TripSeats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {
}
