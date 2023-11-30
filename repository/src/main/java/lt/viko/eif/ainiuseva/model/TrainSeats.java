package lt.viko.eif.ainiuseva.model;

import jakarta.persistence.*;
import lombok.*;

//  id          serial,
//    train_id    integer       not null,
//    seats_count integer       not null,
//    price       numeric(6, 2) not null,
//    class       integer       not null,
@Entity
@Table(name = "train_seats")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TrainSeats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false)
    private Train train;

    @Column
    private Integer seatsCount;

    @Column
    private double price;

    @Column(name = "class")
    private Integer seatClass;
}
