package lt.viko.eif.ainiuseva.error;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainSystemErrorResponse {
    private int code;
    private String message;
}
