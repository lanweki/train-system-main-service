package lt.viko.eif.ainiuseva.response;

import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripDto {

    private int id;

    private LocalTime departureTime;

    private LocalTime destinationTime;

    private LocalTime duration;

    private TrainInfo trainInfo;

    private List<TripClass> tripClass;
}
