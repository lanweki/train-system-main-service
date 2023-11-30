package lt.viko.eif.ainiuseva.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "trip")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @Column
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false)
    private Train train;

    @OneToMany(mappedBy = "trip")
    private List<TripSeats> tripSeats;
}
