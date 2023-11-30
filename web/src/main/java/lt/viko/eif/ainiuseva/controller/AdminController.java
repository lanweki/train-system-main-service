package lt.viko.eif.ainiuseva.controller;

import lt.viko.eif.ainiuseva.request.CreateRouteRequest;
import lt.viko.eif.ainiuseva.request.CreateTrainRequest;
import lt.viko.eif.ainiuseva.request.CreateTripRequest;
import lt.viko.eif.ainiuseva.response.TrainSystemResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping
    public ResponseEntity<TrainSystemResponse> addRoute(@RequestBody CreateRouteRequest request) {
        throw new UnsupportedOperationException();
    }

    @PostMapping
    public ResponseEntity<TrainSystemResponse> addTrip(@RequestBody CreateTripRequest request) {
        throw new UnsupportedOperationException();
    }

    @PostMapping
    public ResponseEntity<TrainSystemResponse> addTrain(@RequestBody CreateTrainRequest request) {
        throw new UnsupportedOperationException();
    }
}
