package lt.viko.eif.ainiuseva.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lt.viko.eif.ainiuseva.exception.NoContentException;
import lt.viko.eif.ainiuseva.mapper.TicketBookingMapper;
import lt.viko.eif.ainiuseva.model.TicketBooking;
import lt.viko.eif.ainiuseva.repository.TicketBookingRepository;
import lt.viko.eif.ainiuseva.request.TicketBookingRequest;
import lt.viko.eif.ainiuseva.response.TicketBookingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class TicketBookingService {

    @Autowired
    private TicketBookingRepository ticketBookingRepository;

    @Autowired
    private TicketBookingMapper ticketBookingMapper;

    @PersistenceContext
    private EntityManager entityManager;

    public TicketBookingResponse bookTicket(TicketBookingRequest request) {
        var ticketBooking = ticketBookingMapper.ticketBookingRequestToTicketBooking(request);

        var savedTicketBooking = ticketBookingRepository.save(ticketBooking);
        entityManager.detach(entityManager.find(TicketBooking.class, savedTicketBooking.getId()));

        var ticketResponse = ticketBookingRepository.getReferenceById(savedTicketBooking.getId());

        return ticketBookingMapper.ticketBookingToTicketBookingResponse(ticketResponse);
    }

    public List<TicketBookingResponse> getUpcomingBooking(int userId) {
        var ticketBookings = ticketBookingRepository.getTicketBookingByUserId(userId);

        var upcomingBookings = ticketBookings.stream().filter(ticketBooking -> {
            LocalDate date = ticketBooking.getTrip().getDate();
            LocalTime time = ticketBooking.getTrip().getRoute().getArrivalTime();
            LocalDateTime dateTime = date.atTime(time);
            return dateTime.isAfter(LocalDateTime.now());
        }).toList();

        if (upcomingBookings.isEmpty()) {
            throw new NoContentException();
        }

        return upcomingBookings.stream()
                .map(tb -> ticketBookingMapper.ticketBookingToTicketBookingResponse(tb))
                .toList();
    }

    public List<TicketBookingResponse> getPastBookings(int userId) {
        var ticketBookings = ticketBookingRepository.getTicketBookingByUserId(userId);

        var pastBookings = ticketBookings.stream().filter(ticketBooking -> {
            LocalDate date = ticketBooking.getTrip().getDate();
            LocalTime time = ticketBooking.getTrip().getRoute().getArrivalTime();
            LocalDateTime dateTime = date.atTime(time);
            return dateTime.isBefore(LocalDateTime.now());
        }).toList();

        if (pastBookings.isEmpty()) {
            throw new NoContentException();
        }

        return pastBookings.stream()
                .map(tb -> ticketBookingMapper.ticketBookingToTicketBookingResponse(tb))
                .toList();
    }
}
