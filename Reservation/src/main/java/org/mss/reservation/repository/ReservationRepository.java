package org.mss.reservation.repository;

import org.mss.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long>{
	

}
