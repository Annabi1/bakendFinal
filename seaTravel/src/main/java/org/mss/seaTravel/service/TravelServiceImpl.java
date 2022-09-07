package org.mss.seaTravel.service;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.mss.seaTravel.Reservation;
import org.mss.seaTravel.model.Travel;
import org.mss.seaTravel.openFeign.FeignOpenReservation;
import org.mss.seaTravel.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class TravelServiceImpl  implements ITravelsService{
	@Autowired
	private FeignOpenReservation feignOpenReservation;
@Autowired
private TravelRepository travelRepo;
@Autowired
private IEmailService emailService;
	@Override
	public Travel createTravel(Travel travel) {
		Optional<Travel> searchTravel=travelRepo.findByDestination(travel.getDestination());
		
		if (searchTravel.isEmpty())
			{travel.setType("Air");
			return travelRepo.save(travel);}
		else
		return null;
	}
	@Override
	public List<Travel> findAll() {
		// TODO Auto-generated method stub
		return travelRepo.findAll();
	}
	@Override
	public Travel save(@Valid Travel travel) {
		// TODO Auto-generated method stub
		Optional<Travel> travelSearched=travelRepo.findByDestination(travel.getDestination());
		if( travelSearched.isEmpty()) {
			travel.setAvailable(false);
			return travelRepo.save(travel);
		}
		else
		return null;
		
	}
	@Override
	public void deleteTravel(long id ) {
		// TODO Auto-generated method stub
		travelRepo.deleteById(id);
	}
	@Override
	public Travel updateTravelAvialbale(long id) {
		 String email;
		// TODO Auto-generated method stub
		Optional<Travel> searchTravel=travelRepo.findById(id);
		if(searchTravel.get().isReserve()) {
			List<Reservation> reservations=this.feignOpenReservation.getAllReservationByIdTravel(id);
			for(Reservation reservation:reservations) {
				email=reservation.getEmail_of_traveler();
				String msg="Welcome  to Mss Consulting the travel with destination  "+searchTravel.get().getDestination()+" which is already scheduled "+searchTravel.get().getDate_depart()+" "+searchTravel.get().getHeure_depart()+" was canceled ";
			    
				if(searchTravel.get().getAvailable()==true)
				{
					searchTravel.get().setAvailable(false);
			        this.emailService.sendEmail(email," Trip cancellation",msg);;

				}
				else 			searchTravel.get().setAvailable(true);

				return searchTravel.get();
			}
				    }

			
		else {	
		if(searchTravel.get().getAvailable()==true)
		{
			searchTravel.get().setAvailable(false);
		}
		else 			searchTravel.get().setAvailable(true);

		return searchTravel.get();
	}
		return null;
		}
	@Override
	public Optional<Travel> getTravelById(long id) {
		// TODO Auto-generated method stub
		return travelRepo.findById(id);
	}
	@Override
	public Optional<Travel> getTravelByMax_capacity(String destination) {
     Optional<Travel> searchTravel= travelRepo.findByDestination(destination);
   if(searchTravel.isEmpty()) {
	   return travelRepo.findByMaxCapacity(destination);

   }
   else return null;
	}
	@Override
	public Travel updateTravel(long id, @Valid Travel travel) {
	 Optional<Travel> serchedTravel=travelRepo.findById(id);
	 serchedTravel.get().setAvailable(travel.getAvailable());
	 serchedTravel.get().setReserve(true);

	 serchedTravel.get().setDestination(travel.getDestination());
	 serchedTravel.get().setDate_depart(travel.getDate_depart());
	 serchedTravel.get().setHeure_depart(travel.getHeure_depart());
	 serchedTravel.get().setMaxCapacity(travel.getMaxCapacity());
	 serchedTravel.get().setCompany(travel.getCompany());
travel=serchedTravel.get();


		return travel;
	}

}
