package lt.viko.eif.ainiuseva.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCredentialsVerificationRequest {

    private String username;

    private String password;
}
