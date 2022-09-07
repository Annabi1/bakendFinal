package org.mss.reservation.model;




import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Reservation")

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_Travel;

    private int nbrPlaces;

    @NotBlank
    @Size(min = 3, max = 50)
    private String destination;
    @Size(min = 3, max = 50)
    private String type;
    public String getType() {
		return type;
	}

	public String getEmail_of_traveler() {
		return email_of_traveler;
	}

	public void setEmail_of_traveler(String email_of_traveler) {
		this.email_of_traveler = email_of_traveler;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Size(min = 3, max = 50)
    private String date_depart;
    
    @Size(min = 3, max = 50)

    private String heure_depart;
    private Date createAt;

    @NotBlank
    @Size(min = 3, max = 50)
    private String company;
    @NotBlank
    @Email
    private  String email_of_traveler;
    
    
    
public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

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

	
	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public int getNbrPlaces() {
		return nbrPlaces;
	}

	public void setNbrPlaces(int nbrPlaces) {
		this.nbrPlaces = nbrPlaces;
	}
	

	public Long getId_travel() {
		return id_Travel;
	}

	public void setId_travel(Long id_travel) {
		this.id_Travel = id_travel;
	}

	

	public Reservation(Long id, Long id_Travel, int nbrPlaces, @NotBlank @Size(min = 3, max = 50) String destination,
			@Size(min = 3, max = 50) String type, @Size(min = 3, max = 50) String date_depart,
			@Size(min = 3, max = 50) String heure_depart, Date createAt,
			@NotBlank @Size(min = 3, max = 50) String company, @NotBlank @Email String email_of_traveler,
			int maxCapacity) {
		super();
		this.id = id;
		this.id_Travel = id_Travel;
		this.nbrPlaces = nbrPlaces;
		this.destination = destination;
		this.type = type;
		this.date_depart = date_depart;
		this.heure_depart = heure_depart;
		this.createAt = createAt;
		this.company = company;
		this.email_of_traveler = email_of_traveler;
		this.maxCapacity = maxCapacity;
	}

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}




	

	
}