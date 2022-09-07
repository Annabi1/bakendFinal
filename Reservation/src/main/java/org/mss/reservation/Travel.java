package org.mss.reservation;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Travel {
	
	    private Long id;
	    private int maxCapacity;
	    private boolean reserve;
	    private String destination;
	    private String type;
	    private String date_depart;
	    private String heure_depart;
	    private Boolean available;   
	    private String company;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public boolean isReserve() {
			return reserve;
		}
		public void setReserve(boolean reserve) {
			this.reserve = reserve;
		}
		public String getDestination() {
			return destination;
		}
		public void setDestination(String destination) {
			this.destination = destination;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
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
		public Boolean getAvailable() {
			return available;
		}
		public void setAvailable(Boolean available) {
			this.available = available;
		}
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}
	
		public Travel() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getMaxCapacity() {
			return maxCapacity;
		}
		public void setMaxCapacity(int maxCapacity) {
			this.maxCapacity = maxCapacity;
		}
		public Travel(Long id, int maxCapacity, boolean reserve, String destination, String type, String date_depart,
				String heure_depart, Boolean available, String company) {
			super();
			this.id = id;
			this.maxCapacity = maxCapacity;
			this.reserve = reserve;
			this.destination = destination;
			this.type = type;
			this.date_depart = date_depart;
			this.heure_depart = heure_depart;
			this.available = available;
			this.company = company;
		}
		

	 
	   






		


}
