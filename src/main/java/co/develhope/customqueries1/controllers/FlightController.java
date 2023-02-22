package co.develhope.customqueries1.controllers;

import co.develhope.customqueries1.entities.Flight;
import co.develhope.customqueries1.entities.FlightStatus;
import co.develhope.customqueries1.repositories.FlightRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @GetMapping("/provisioning")
    public void flightsProvisioning(){
        List<Flight> newFlights = new ArrayList<>();
        for(int i = 0; i < 50; i++){
            Flight flight = new Flight();
            Random random = new Random();
            flight.setDescription(random.ints().toString());
            flight.setFromAirport(random.ints().toString());
            flight.setToAirport(random.ints().toString());
            flight.setStatus(FlightStatus.ONTIME);
            newFlights.add(flight);
        }
        flightRepository.saveAll(newFlights);
    }
    @GetMapping("/getFlights")
    public List<Flight> getFlights(){
        return flightRepository.findAll();
    }



}
