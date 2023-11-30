package lt.viko.eif.ainiuseva.controller;

import lt.viko.eif.ainiuseva.request.TripSearchRequest;
import lt.viko.eif.ainiuseva.response.TripSearchResponse;
import lt.viko.eif.ainiuseva.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trips")
public class TripController {

    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping
    public ResponseEntity<TripSearchResponse> getTrips(@RequestBody TripSearchRequest tripSearchRequest) {
        var response = tripService.getTrips(tripSearchRequest);
        return ResponseEntity.ok(response);
    }
}
