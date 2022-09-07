package org.mss.airTravel.model;


import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Air_Travel")

public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean reserve;

    @NotBlank
    @Size(min = 3, max = 50)
    private String destination;
    @Size(min = 3, max = 50)
    private String type;
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Size(min = 3, max = 50)
    private String date_depart;
    
    @Size(min = 3, max = 50)
    @JsonFormat(pattern="HH:mm")

    private String heure_depart;
    private Boolean available;   
    @NotBlank
    @Size(min = 3, max = 50)
    private String company;

public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

private int maxCapacity;
   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
   

 
   






	


	
	public Boolean getAvailable() {
		return available;
	}

	public String getDate_depart() {
		return date_depart;
	}

	public void setDate_depart(String date_depart) {
		this.date_depart = date_depart;
	}

	public String getHeure_depart() {
		return heure_depart;
	}

	public void setHeure_depart(String heure_depart) {
		this.heure_depart = heure_depart;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	

	

	public Travel(Long id, boolean reserve, @NotBlank @Size(min = 3, max = 50) String destination,
			@Size(min = 3, max = 50) String type, @Size(min = 3, max = 50) String date_depart,
			@Size(min = 3, max = 50) String heure_depart, Boolean available,
			@NotBlank @Size(min = 3, max = 50) String company, int maxCapacity) {
		super();
		this.id = id;
		this.reserve = reserve;
		this.destination = destination;
		this.type = type;
		this.date_depart = date_depart;
		this.heure_depart = heure_depart;
		this.available = available;
		this.company = company;
		this.maxCapacity = maxCapacity;
	}

	public boolean isReserve() {
		return reserve;
	}

	public void setReserve(boolean reserve) {
		this.reserve = reserve;
	}

	public Travel() {
    }
}