package lt.viko.eif.ainiuseva.mapper;

import lt.viko.eif.ainiuseva.model.TicketBooking;
import lt.viko.eif.ainiuseva.model.Trip;
import lt.viko.eif.ainiuseva.model.User;
import lt.viko.eif.ainiuseva.request.TicketBookingRequest;
import lt.viko.eif.ainiuseva.response.TicketBookingResponse;
import lt.viko.eif.ainiuseva.response.TrainInfo;
import org.springframework.stereotype.Component;

@Component
public class TicketBookingMapper {

    public TicketBookingResponse ticketBookingToTicketBookingResponse(TicketBooking ticketBooking) {
        TicketBookingResponse ticketBookingResponse = new TicketBookingResponse();

        ticketBookingResponse.setId(ticketBooking.getId());
        ticketBookingResponse.setDepartureCity(ticketBooking.getTrip().getRoute().getDeparture());
        ticketBookingResponse.setDestinationCity(ticketBooking.getTrip().getRoute().getDestination());
        ticketBookingResponse.setDate(ticketBooking.getTrip().getDate());
        ticketBookingResponse.setDuration(ticketBooking.getTrip().getRoute().getDuration());
        ticketBookingResponse.setDepartureTime(ticketBooking.getTrip().getRoute().getDepartureTime());
        ticketBookingResponse.setDestinationTime(ticketBooking.getTrip().getRoute().getArrivalTime());

        TrainInfo trainInfo = new TrainInfo();
        trainInfo.setName(ticketBooking.getTrip().getTrain().getName());
        trainInfo.setNumber(ticketBooking.getTrip().getTrain().getNumber());
        ticketBookingResponse.setTrainInfo(trainInfo);

        ticketBookingResponse.setSeatClass(ticketBooking.getSeatClass());

        return ticketBookingResponse;
    }

    public TicketBooking ticketBookingRequestToTicketBooking(TicketBookingRequest request) {
        TicketBooking ticketBooking = new TicketBooking();

        ticketBooking.setName(request.getName());
        ticketBooking.setSurname(request.getSurname());
        ticketBooking.setEmail(request.getEmail());
        ticketBooking.setSeatClass(request.getSeatClass());

        Trip trip = new Trip();
        trip.setId(request.getTripId());
        ticketBooking.setTrip(trip);

        if (request.getUserId() != null) {
            User user = new User();
            user.setId(request.getUserId());
            ticketBooking.setUser(user);
        }

        return ticketBooking;
    }
}
