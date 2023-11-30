package lt.viko.eif.ainiuseva.request;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripSearchRequest {

    private String departureCity;

    private String destinationCity;

    private LocalDate date;
}
