package lt.viko.eif.ainiuseva.repository;

import lt.viko.eif.ainiuseva.model.Trip;
import lt.viko.eif.ainiuseva.model.TripSeats;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {

    @Query(value = "SELECT t FROM Trip t " +
            "WHERE t.date = :date " +
            "AND t.route.departure = :departure " +
            "AND t.route.destination = :destination")
    List<Trip> findAllByRoute(
            @Param("date") LocalDate date,
            @Param("departure") String departure,
            @Param("destination") String destination);
}
