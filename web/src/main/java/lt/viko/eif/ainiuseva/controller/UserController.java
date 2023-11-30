package lt.viko.eif.ainiuseva.controller;

import lt.viko.eif.ainiuseva.request.UserCredentialsVerificationRequest;
import lt.viko.eif.ainiuseva.request.UserRegistrationRequest;
import lt.viko.eif.ainiuseva.response.TicketBookingResponse;
import lt.viko.eif.ainiuseva.response.TrainSystemResponse;
import lt.viko.eif.ainiuseva.response.UserDetails;
import lt.viko.eif.ainiuseva.service.TicketBookingService;
import lt.viko.eif.ainiuseva.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService ) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<TrainSystemResponse> addNewUser(@RequestBody UserRegistrationRequest request) {
        var response = userService.addNewUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<TrainSystemResponse> verifyCredentials(@RequestBody UserCredentialsVerificationRequest request) {
        var response = userService.verifyCredentials(request);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}/details")
    public ResponseEntity<UserDetails> getUserDetails(@PathVariable int userId) {
        var response = userService.getUserDetails(userId);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/password")
    public ResponseEntity<TrainSystemResponse> changePassword(@PathVariable int userId) {
        throw new UnsupportedOperationException();
    }
}
