package org.mss.seaTravel.repository;


import org.mss.seaTravel.model.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TravelRepository  extends JpaRepository<Travel,Long> {
    public Optional<Travel>findByDestination(String destination);

	public Optional<Travel> findByMaxCapacity(String destination);
}
