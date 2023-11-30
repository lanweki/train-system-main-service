package lt.viko.eif.ainiuseva.response;

import jakarta.persistence.Column;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainInfo {

    private String name;


    private String number;
}
