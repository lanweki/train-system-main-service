package lt.viko.eif.ainiuseva.mapper;

import lt.viko.eif.ainiuseva.model.User;
import lt.viko.eif.ainiuseva.request.UserRegistrationRequest;
import lt.viko.eif.ainiuseva.response.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User userRegistrationRequestToUser(UserRegistrationRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setEmail(request.getEmail());

        return user;
    }

    public UserDetails userToUserDetails(User user) {
        UserDetails userDetails = new UserDetails();
        userDetails.setUsername(user.getUsername());
        userDetails.setName(user.getName());
        userDetails.setSurname(user.getSurname());
        userDetails.setEmail(user.getEmail());

        return userDetails;
    }
}
