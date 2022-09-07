package org.mss.airTravel.openFeign;

import java.util.List;


import java.util.Optional;

import org.mss.airTravel.Reservation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="reservation" , url="http://localhost:8080/api/reservation")
public interface FeignOpenReservation {
	@GetMapping(value="/{id}")
	Optional<Reservation> getReservationByIdTravel(@PathVariable("id") Long id);
	@GetMapping(value="/")
	List<Reservation> getAllReservation();
	@GetMapping(value="/{id}")
	List<Reservation> getAllReservationByIdTravel(@PathVariable("id") Long id);

}
