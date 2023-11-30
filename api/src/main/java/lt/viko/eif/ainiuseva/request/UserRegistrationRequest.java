package lt.viko.eif.ainiuseva.request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserRegistrationRequest {

    private String username;

    private String password;

    private String name;

    private String surname;

    private String email;
}