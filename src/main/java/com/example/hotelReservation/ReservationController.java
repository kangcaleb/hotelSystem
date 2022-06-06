package com.example.hotelReservation;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType.*;
import com.example.hotelReservation.ReservationSystem.Reservation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ReservationController {
    private ReservationSystem system = new ReservationSystem();

    @GetMapping("/reservation")
    public Reservation getReservation(@RequestParam(value = "id") int id) {
        return system.getReservation(id);
    }

    @RequestMapping(value = "createReservation", method = RequestMethod.POST)
    public ReservationConfirmation createReservation(@RequestBody ReservationRequest reservation)  {
        return new ReservationConfirmation(system.makeReservation(reservation));
    }

    @GetMapping("/reservationsWithSubstring")
    public List<Reservation> getReservationsWithSubtring(@RequestParam(value="substring") String substring) {
        return system.getReservationsWithSubstring(substring);
    }


    // Extra
    @GetMapping
    public String helloWorld() {
        return "Hello, World!";
    }

    @GetMapping("/reservations")
    public Map<Integer, Reservation> getReservations() {
        return system.getAllReservations();
    }

    public class ReservationConfirmation {

        private int id;
        private int roomNumber;

        private ReservationConfirmation(Reservation reservation) {
            this.id = reservation.getId();
            this.roomNumber = reservation.getRoomNumber();
        }

        public int getRoomNumber() {
            return roomNumber;
        }

        public int getId() {
            return id;
        }
    }
}
