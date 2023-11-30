package lt.viko.eif.ainiuseva.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketBookingRequest {

    private Integer userId;

    private int tripId;

    private String name;

    private String surname;

    private String email;

    private int seatClass;
}
