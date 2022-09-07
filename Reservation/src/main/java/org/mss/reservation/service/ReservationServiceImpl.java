package org.mss.reservation.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.mss.reservation.Travel;
import org.mss.reservation.feignOpen.SeaTravelFeignOpen;
import org.mss.reservation.model.Reservation;
import org.mss.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ReservationServiceImpl  implements IReservationService{
	@Autowired
	private SeaTravelFeignOpen seaTravelFeignOpen;
	@Autowired
	private ReservationRepository repo;
	@Override
	public Reservation reserver(Reservation reservation) {
Optional<Travel> travel=this.seaTravelFeignOpen.getTravelByIdTravel(reservation.getId_travel());
	travel.get().setMaxCapacity(20);
	Optional<Travel> travelt=this.seaTravelFeignOpen.updateTravel(reservation.getId_travel(), travel.get());
	System.out.println(travelt.get().isReserve());
	return repo.save(reservation);

}
	
	@Override
	public Reservation save(@Valid Reservation reservation) {
		// TODO Auto-generated method stub
		return repo.save(reservation);
	}
	@Override
	public List<Reservation> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
