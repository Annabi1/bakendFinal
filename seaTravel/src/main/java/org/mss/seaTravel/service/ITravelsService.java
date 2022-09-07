package org.mss.seaTravel.service;

import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.mss.seaTravel.model.Travel;


public interface ITravelsService {
	public Travel createTravel(Travel travel);
	public void deleteTravel(long id );

	public List<Travel> findAll();
	public Travel save(@Valid Travel travel);

	public Travel updateTravelAvialbale(long id);
	public Optional<Travel> getTravelById(long id);
	public Optional<Travel> getTravelByMax_capacity(String destination);
	public Travel updateTravel(long id, @Valid Travel travel);

	//public Optional<Travel> getTravelByDestination(long id);

}
