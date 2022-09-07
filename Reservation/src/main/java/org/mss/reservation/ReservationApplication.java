package org.mss.reservation;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import org.mss.reservation.feignOpen.SeaTravelFeignOpen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ReservationApplication {
	@Autowired
	private SeaTravelFeignOpen TravelFeignOpen;

	public static void main(String[] args) {
		SpringApplication.run(ReservationApplication.class, args);
	}

	  @Bean CommandLineRunner runner() { return args -> {
		  
	  Optional<Travel> travel=this.TravelFeignOpen.getTravelByIdTravel(3l);
	  System.out.println(travel.get().getDestination());
				travel.get().setMaxCapacity(50);
			Optional<Travel>travelUP=this.TravelFeignOpen.updateTravel(3l, travel.get());
			  System.out.println(travelUP.get().getMaxCapacity());
			  System.out.println(travelUP.get().isReserve());

	  
	  };
	  
	  }
	  

}

