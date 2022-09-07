package org.mss.airTravel.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.mss.airTravel.model.Travel;
import org.mss.airTravel.service.ITravelsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/airTravels")
public class TravelResource {
	 private final Logger log = LoggerFactory.getLogger(TravelResource.class);
		private  final ITravelsService service;
	 
	 public TravelResource(ITravelsService service) {
			super();
			this.service = service;
		}

	@GetMapping("/")
	    public  List<Travel> getAllTravels() {
	        log.debug("REST request to get all user");
	        return service.findAll();
	    }
	@PostMapping("/")
    public ResponseEntity<Travel> createTravel(@Valid @RequestBody Travel travel) throws URISyntaxException {
        log.debug("REST request to save travel : {}", travel);
        travel.setType("Air travel");
        Travel result = service.save(travel);
        return ResponseEntity.created(new URI("/api/travels/" + result))
                .body(result);
    }
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteTravel(@PathVariable Long id ) {
	        log.debug("REST request to delete Travel : {}", id);
	        service.deleteTravel(id);
	        return ResponseEntity.noContent().build();
	    }
	 @GetMapping("/{id}")
	    public ResponseEntity<Travel> getTravelById(@PathVariable long id) {
	        log.debug("REST request to get travel : {}", id);
	       Optional< Travel> travel = service.getTravelById(id);
	        return ResponseEntity.ok().body(travel.get());
	    }
	 @GetMapping("/capacity/")
	    public ResponseEntity<Travel> getTravelByCapacity(@RequestParam String destination) {
	        log.debug("REST request to get travel : {}", destination);
	       Optional< Travel> travel = service.getTravelByMax_capacity(destination);
	        return ResponseEntity.ok().body(travel.get());
	    }
	  @PutMapping("/{id}")
	    public ResponseEntity<Travel> updateTravelAvialbale(   @PathVariable long id,@Valid @RequestBody Travel travel ) throws URISyntaxException {

	        Travel result = service.updateTravelAvialbale(id);
	        return ResponseEntity.ok()
	                .body(result);
	    }
	  @PutMapping("/update/{id}")
	    public ResponseEntity<Travel> updateTravel(   @PathVariable long id,@Valid @RequestBody Travel travel ) throws URISyntaxException {
travel.setReserve(true);
	        Travel result = service.updateTravel(id,travel);
	        return ResponseEntity.ok()
	                .body(result);
	    }

}
