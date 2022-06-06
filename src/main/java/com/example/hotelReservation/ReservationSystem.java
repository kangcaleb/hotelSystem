package com.example.hotelReservation;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReservationSystem {
    private Map<Integer, Reservation> data;
    private final AtomicInteger idCounter = new AtomicInteger();
    private final AtomicInteger roomCounter = new AtomicInteger(100);

    public ReservationSystem() {
        this.data = new HashMap<>();
    }

    public List<Reservation> getReservationsWithSubstring(String substring) {
        List filtered = data.values().stream().filter(new Predicate<Reservation>() {
            @Override
            public boolean test(Reservation reservation) {
                return reservation.getName().contains(substring);
            }
        }).collect(Collectors.toList());

        return filtered;
    }

    public Reservation getReservation(int id) {
        return data.get(id);
    }

    public Reservation makeReservation(ReservationRequest request) {
        int id = idCounter.incrementAndGet();
        Reservation res = new Reservation(id, request.getName(), request.getPhoneNumber(),
                request.getArrivalDate(), request.getNumNights(), roomCounter.incrementAndGet());
        data.put(id, res);
        return res;
    }

    public Map<Integer, Reservation> getAllReservations() {
        return data;
    }

    public class Reservation {

        private int id;
        private String name;
        private String phoneNumber;
        private String arrivalDate;
        private int numNights;
        private int roomNumber;

        private Reservation(int id, String name, String phoneNumber, String arrivalDate, int numNights, int roomNumber) {
            this.id = id;
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.arrivalDate = arrivalDate;
            this.numNights = numNights;
            this.roomNumber = roomNumber;
        }

        public String getName() {
            return name;
        }
        public String getArrivalDate() {
            return arrivalDate;
        }
        public int getId() {
            return id;
        }
        public int getNumNights() {
            return numNights;
        }
        public String getPhoneNumber() {
            return phoneNumber;
        }
        public int getRoomNumber() {
            return roomNumber;
        }
    }
}
