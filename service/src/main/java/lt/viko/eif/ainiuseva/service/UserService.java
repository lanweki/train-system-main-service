package lt.viko.eif.ainiuseva.service;

import lt.viko.eif.ainiuseva.exception.EntityAlreadyExistException;
import lt.viko.eif.ainiuseva.exception.IncorrectCredentialsException;
import lt.viko.eif.ainiuseva.mapper.UserMapper;
import lt.viko.eif.ainiuseva.model.User;
import lt.viko.eif.ainiuseva.repository.UserRepository;
import lt.viko.eif.ainiuseva.request.UserCredentialsVerificationRequest;
import lt.viko.eif.ainiuseva.request.UserRegistrationRequest;
import lt.viko.eif.ainiuseva.response.TrainSystemResponse;
import lt.viko.eif.ainiuseva.response.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public TrainSystemResponse addNewUser(UserRegistrationRequest request) {
        var optionalUser = userRepository.getUserByUsernameOrEmail(request.getUsername(), request.getEmail());

        if (optionalUser.isPresent()) {
            throw new EntityAlreadyExistException();
        }

        var user = userMapper.userRegistrationRequestToUser(request);

        userRepository.save(user);

        return new TrainSystemResponse("User was successfully registered.");
    }

    public TrainSystemResponse verifyCredentials(UserCredentialsVerificationRequest request) {
        var optionalUser = userRepository.getUserByUsernameAndPassword(request.getUsername(), request.getPassword());

        if (optionalUser.isEmpty()) {
            throw new IncorrectCredentialsException();
        }

        return new TrainSystemResponse("Provided user credentials are valid.");
    }

    public UserDetails getUserDetails(int userId){
        var user = userRepository.getReferenceById(userId);

        return userMapper.userToUserDetails(user);
    }
}
