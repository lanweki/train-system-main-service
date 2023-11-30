package lt.viko.eif.ainiuseva.controller;

import lt.viko.eif.ainiuseva.request.TicketBookingRequest;
import lt.viko.eif.ainiuseva.response.TicketBookingResponse;
import lt.viko.eif.ainiuseva.response.TrainSystemResponse;
import lt.viko.eif.ainiuseva.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class TicketBookingController {

    @Autowired
    private TicketBookingService ticketBookingService;

    @PostMapping
    public ResponseEntity<TicketBookingResponse> ticketBooking(@RequestBody TicketBookingRequest request) {
        var response = ticketBookingService.bookTicket(request);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/upcoming")
    public ResponseEntity<List<TicketBookingResponse>> getUpcomingBooking(@RequestParam int userId) {
        var response = ticketBookingService.getUpcomingBooking(userId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/past")
    public ResponseEntity<List<TicketBookingResponse>> getPastTrips(@RequestParam int userId) {
        var response = ticketBookingService.getPastBookings(userId);

        return ResponseEntity.ok(response);
    }
}
