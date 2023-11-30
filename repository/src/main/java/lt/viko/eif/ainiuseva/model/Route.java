package lt.viko.eif.ainiuseva.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "route")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "departure_city")
    private String departure;

    @Column(name = "destination_city")
    private String destination;

    @Column
    private LocalTime departureTime;

    @Column
    private LocalTime arrivalTime;

    @Column
    private LocalTime duration;

    @OneToMany(mappedBy = "route")
    private List<Trip> trips;
}
