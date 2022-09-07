package org.mss.airTravel;

import java.sql.Time;


import java.util.Date;
import java.util.List;

import org.mss.airTravel.model.Travel;
import org.mss.airTravel.openFeign.FeignOpenReservation;
import org.mss.airTravel.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class AirTravelApplication {
@Autowired
private TravelRepository travelRepo;
	public static void main(String[] args) {
		SpringApplication.run(AirTravelApplication.class, args);

		System.out.println("************************* start ************************* ");
		
	}
	@Autowired
	private  FeignOpenReservation feignOpenReservation;
	
	/*  @Bean CommandLineRunner runner() { return args -> {
		  //System.out.println(this.feignOpenReservation.getAllReservation());
		 List<Reservation>reservations=this.feignOpenReservation.getAllReservationByIdTravel(2L);
		 for(Reservation reservation:reservations) {
				System.out.println(reservation.getEmail_of_traveler());
				}*/

		  
	  
	
	  
	  
	  
	  //};
	  
	  }
	 
	
//}