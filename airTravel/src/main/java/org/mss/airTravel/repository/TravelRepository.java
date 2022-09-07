package org.mss.airTravel.repository;

import org.mss.airTravel.model.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TravelRepository  extends JpaRepository<Travel,Long> {
    public Optional<Travel>findByDestination(String destination);
    public Optional<Travel>findByMaxCapacity(String destination);

}
