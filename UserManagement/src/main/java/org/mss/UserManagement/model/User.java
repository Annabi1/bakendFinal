
package org.mss.UserManagement.model;
import java.util.HashSet;

import java.util.List;
import java.util.Set;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")

public class User {
	@Id
	  @NotBlank
	    @Email
	    @Column(unique=true)
	    @Size(max = 50)
	    
	    private String email;

    @NotBlank
    @Size(min=3, max = 50)
    private String firstname;

    @NotBlank
    @Size(min=3, max = 50)
    private String lastname;
    private Boolean enabled;
    @NotBlank
    @Size(min=6, max = 100)
    private String password;
    
    private String gender;
    
    private String birthDate;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    
  

    public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	  @ManyToOne()
	  @JoinColumn(name = "id_role", nullable = false,referencedColumnName="name")
    private Role role;
	


	public User(@NotBlank @Email @Size(max = 50) String email, @NotBlank @Size(min = 3, max = 50) String firstname,
			@NotBlank @Size(min = 3, max = 50) String lastname, Boolean enabled,
			@NotBlank @Size(min = 6, max = 100) String password, String gender, String birthDate, Date createAt,
			Role role) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.enabled = enabled;
		this.password = password;
		this.gender = gender;
		this.birthDate = birthDate;
		this.createAt = createAt;
		this.role = role;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User() {}



	


   
	
	

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public  String getEmail() {
        return email;
    }

    public  void setEmail(String email) {
        this.email = email;
    }

    public  String getPassword() {
        return password;
    }

    public  void setPassword(String password) {
        this.password = password;
    }

    public  String getGender() {
		return gender;
	}

	public  void setGender(String gender) {
		this.gender = gender;
	}


	public  String getBirthDate() {
		return birthDate;
	}

	public  void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public  Date getCreateAt() {
		return createAt;
	}

	public  void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}


	
	
    
}
