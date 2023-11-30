package lt.viko.eif.ainiuseva.service;

import lt.viko.eif.ainiuseva.exception.TripsNotFoundException;
import lt.viko.eif.ainiuseva.mapper.TripMapper;
import lt.viko.eif.ainiuseva.model.TicketBooking;
import lt.viko.eif.ainiuseva.model.Trip;
import lt.viko.eif.ainiuseva.repository.TripRepository;
import lt.viko.eif.ainiuseva.request.TripSearchRequest;
import lt.viko.eif.ainiuseva.response.TripDto;
import lt.viko.eif.ainiuseva.response.TicketBookingResponse;
import lt.viko.eif.ainiuseva.response.TripSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private TripMapper tripMapper;


    public TripSearchResponse getTrips(TripSearchRequest request) {
        TripSearchResponse response = new TripSearchResponse();

        List<Trip> trips = tripRepository.findAllByRoute(request.getDate(), request.getDepartureCity(), request.getDestinationCity());

        if (trips.isEmpty()) {
            throw new TripsNotFoundException(request.getDate().toString(), request.getDepartureCity(), request.getDestinationCity());
        }

        response.setDate(request.getDate());
        response.setDepartureCity(request.getDepartureCity());
        response.setDestinationCity(request.getDestinationCity());

        List<TripDto> tripDtoResponses = trips.stream().map(trip -> tripMapper.tripToTripDto(trip)).collect(Collectors.toList());

        response.setTripDtos(tripDtoResponses);
        return response;
    }

}
