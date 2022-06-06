package com.example.hotelReservation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.hotelReservation.ReservationController.ReservationConfirmation;
import com.example.hotelReservation.ReservationSystem.Reservation;

import java.util.List;

@SpringBootTest
class HotelReservationApplicationTests {

	@Test
	void testGetReservationById() {
		ReservationRequest request = new ReservationRequest("Caleb", "5108722465", "12-16-1998", 999);
		ReservationController controller = new ReservationController();

		ReservationConfirmation res = controller.createReservation(request);
		int id = res.getId();

		assert controller.getReservation(id).getName() == "Caleb";
		assert controller.getReservation(id).getPhoneNumber() == "5108722465";
		assert controller.getReservation(id).getArrivalDate() == "12-16-1998";
		assert controller.getReservation(id).getNumNights() == 999;
	}

	@Test
	void testGetReservationWithNoId() {
		ReservationController controller = new ReservationController();
		Reservation res = controller.getReservation(1);

		assert res == null;
	}

	@Test
	void testSize() {
		ReservationRequest request = new ReservationRequest("Caleb", "5108722465", "12-16-1998", 1);
		ReservationController controller = new ReservationController();
		assert controller.getReservations().size() == 0;

		ReservationConfirmation res = controller.createReservation(request);
		assert controller.getReservations().size() == 1;
		assert controller.getReservations().get(res.getId()).getName() == "Caleb";
		assert controller.getReservations().get(res.getId()).getPhoneNumber() == "5108722465";

		// Add another request
		ReservationConfirmation res1 = controller.createReservation(new ReservationRequest("Morgan", "8654091021", "02-16-2022", 2));
		assert controller.getReservations().size() == 2;
		assert controller.getReservations().get(res1.getId()).getName() == "Morgan";
		assert controller.getReservations().get(res1.getId()).getPhoneNumber() == "8654091021";
	}

	@Test
	void testGetbySubstringWithOne() {
		ReservationController controller = new ReservationController();

		ReservationRequest request = new ReservationRequest("Caleb", "5108722465", "12-16-1998", 1);
		ReservationRequest another = new ReservationRequest("Morgan", "8654091021", "02-16-2022", 2);
		controller.createReservation(request);
		controller.createReservation(another);

		List<Reservation> reservations = controller.getReservationsWithSubtring("Cal");

		assert reservations.size() == 1;
		assert reservations.get(0).getName() == "Caleb";
	}
}
