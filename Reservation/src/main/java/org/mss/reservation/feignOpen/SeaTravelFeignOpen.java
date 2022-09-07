package org.mss.reservation.feignOpen;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import javax.validation.Valid;

import org.mss.reservation.Travel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name="SeaTravels" , url="http://localhost:8084/api/SeaTravels")
public interface SeaTravelFeignOpen {
		@GetMapping(value="/{id}")
		Optional<Travel> getTravelByIdTravel(@PathVariable("id") Long id);
		  @PutMapping("/update/{id}")
		  Optional<Travel>updateTravel(   @PathVariable long id,@Valid @RequestBody Travel travel );
		  
}

