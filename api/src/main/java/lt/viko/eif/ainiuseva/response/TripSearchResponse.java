package lt.viko.eif.ainiuseva.response;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripSearchResponse {

    private String departureCity;

    private String destinationCity;

    private LocalDate date;

    private List<TripDto> tripDtos;

}
