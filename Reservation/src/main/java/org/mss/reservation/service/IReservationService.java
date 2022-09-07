package org.mss.reservation.service;

import java.util.List;

import javax.validation.Valid;

import org.mss.reservation.model.Reservation;

public interface IReservationService {
	Reservation reserver(Reservation reservation);

	Reservation save(@Valid Reservation reservation);

	List<Reservation> findAll();

}
