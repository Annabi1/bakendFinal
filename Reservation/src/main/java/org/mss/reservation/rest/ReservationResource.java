package org.mss.reservation.rest;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.mss.reservation.model.Reservation;
import org.mss.reservation.service.IReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/reservation/")
public class ReservationResource {
	 private final Logger log = LoggerFactory.getLogger(ReservationResource.class);
		private final IReservationService service ;
		public ReservationResource(IReservationService service) {
			super();
			this.service = service;
		}
		@GetMapping("/")
	    public  List<Reservation> getAllReservations() {
	        log.debug("REST request to get all Reservations");
	        return service.findAll();
	    }
		@PostMapping("/")
	    public ResponseEntity<Reservation> createReservation(@Valid @RequestBody Reservation reservation) throws URISyntaxException {
	        log.debug("REST request to save Reservation : {}", reservation);
	        reservation.setCreateAt(new Date());
	        Reservation result = service.save(reservation);
	        return ResponseEntity.created(new URI("/api/reservation/" + result))
	                .body(result);
	    }
}
