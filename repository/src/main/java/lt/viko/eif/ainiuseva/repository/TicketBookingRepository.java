package lt.viko.eif.ainiuseva.repository;

import lt.viko.eif.ainiuseva.model.TicketBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketBookingRepository extends JpaRepository<TicketBooking, Integer> {

    @Query(value = "SELECT tb FROM TicketBooking tb WHERE tb.user.id = :userId")
    List<TicketBooking> getTicketBookingByUserId(int userId);
}
