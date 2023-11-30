package lt.viko.eif.ainiuseva.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {

    private String username;

    private String name;

    private String surname;

    private String email;
}
