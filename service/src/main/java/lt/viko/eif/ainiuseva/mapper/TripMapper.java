package lt.viko.eif.ainiuseva.mapper;

import lt.viko.eif.ainiuseva.model.TicketBooking;
import lt.viko.eif.ainiuseva.model.Trip;
import lt.viko.eif.ainiuseva.response.TrainInfo;
import lt.viko.eif.ainiuseva.response.TripClass;
import lt.viko.eif.ainiuseva.response.TripDto;
import lt.viko.eif.ainiuseva.response.TicketBookingResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TripMapper {

    public TripDto tripToTripDto(Trip trip) {
        TripDto tripDtoResponse = new TripDto();
        tripDtoResponse.setId(trip.getId());
        tripDtoResponse.setDuration(trip.getRoute().getDuration());
        tripDtoResponse.setDepartureTime(trip.getRoute().getDepartureTime());
        tripDtoResponse.setDestinationTime(trip.getRoute().getArrivalTime());

        TrainInfo trainInfo = new TrainInfo();
        trainInfo.setName(trip.getTrain().getName());
        trainInfo.setNumber(trip.getTrain().getNumber());
        tripDtoResponse.setTrainInfo(trainInfo);


        List<TripClass> tripClassList = trip.getTrain().getTrainSeats().stream()
                .map(trainSeats -> new TripClass(trainSeats.getSeatClass(), trainSeats.getPrice())).collect(Collectors.toList());
        tripDtoResponse.setTripClass(tripClassList);

        return tripDtoResponse;
    }


}
