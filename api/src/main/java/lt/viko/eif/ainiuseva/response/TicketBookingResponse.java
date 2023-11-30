package lt.viko.eif.ainiuseva.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketBookingResponse {

    private int id;

    private String departureCity;

    private String destinationCity;

    private LocalDate date;

    private LocalTime departureTime;

    private LocalTime destinationTime;

    private LocalTime duration;

    private TrainInfo trainInfo;

    private Integer seatClass;
}
