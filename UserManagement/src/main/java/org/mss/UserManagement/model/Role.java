
package org.mss.UserManagement.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "roles")
public class Role {
	  @Id
	  

	    @Enumerated(EnumType.STRING)
	    @Column(length = 60)
	    private RoleName name;
	    @Column(length = 255)
	    private String description;
	
	    
	    

		

	   

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

	

	

		public Role() {}

	    public Role(RoleName name) {
	        this.name = name;
	    }
	    

	   	


			
	 
	  

	    @OneToMany()
	    private Set<User> users;
		public Role( RoleName name, String description, Set<User> users) {
			super();
			this.name = name;
			this.description = description;
			this.users = users;
		}

		public Set<User> getUsers() {
			return users;
		}

		public void setUsers(Set<User> users) {
			this.users = users;
		}

		public Role(RoleName name, String description) {
this.name=name;
this.description=description;}

		public RoleName getName() {
	        return name;
	    }

	    public void setName(RoleName name) {
	        this.name = name;
	    }

		
}
