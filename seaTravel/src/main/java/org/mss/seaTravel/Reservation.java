package org.mss.seaTravel;



public class Reservation {     
	private Long id;
    private Long id_Travel;
    private String destination;
    private String email_of_traveler;
    private String date_depart;
    private String heure_depart;
    private String type;
    private String company;
    private int nbrPlaces;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_Travel() {
		return id_Travel;
	}
	public void setId_Travel(Long id_Travel) {
		this.id_Travel = id_Travel;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getEmail_of_traveler() {
		return email_of_traveler;
	}
	public void setEmail_of_traveler(String email_of_traveler) {
		this.email_of_traveler = email_of_traveler;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getNbrPlaces() {
		return nbrPlaces;
	}
	public void setNbrPlaces(int nbrPlaces) {
		this.nbrPlaces = nbrPlaces;
	}
    

}
