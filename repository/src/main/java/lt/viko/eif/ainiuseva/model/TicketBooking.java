package lt.viko.eif.ainiuseva.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ticket_booking")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TicketBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @Column
    private Integer seatClass;

    @Column
    private String transactionNumber;

    @Column
    private LocalDateTime bookingTime;

    @PrePersist
    public void onPrePersist() {
        this.setBookingTime(LocalDateTime.now());
        this.setTransactionNumber(UUID.randomUUID().toString());
    }
}
