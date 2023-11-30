package lt.viko.eif.ainiuseva.model;

import jakarta.persistence.*;
import lombok.*;

//    id              serial,
//    trip_id         integer not null,
//    class           integer not null,
//    available_seats integer not null,

@Entity
@Table(name = "trip_seats")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TripSeats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @Column(name = "class")
    private Integer seatClass;

    @Column
    private Integer availableSeats;

    @Override
    public String toString() {
        return "TripSeats{" +
                "id=" + id +
                ", seatClass=" + seatClass +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
