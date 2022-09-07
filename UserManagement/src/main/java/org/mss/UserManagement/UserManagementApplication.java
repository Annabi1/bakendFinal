package org.mss.UserManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Date;
import java.util.List;

import org.mss.UserManagement.model.AES256;
import org.mss.UserManagement.model.Role;
import org.mss.UserManagement.model.RoleName;
import org.mss.UserManagement.model.User;
import org.mss.UserManagement.repository.RoleRepository;
import org.mss.UserManagement.repository.UserRepository;
import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableDiscoveryClient
@SpringBootApplication
public class UserManagementApplication {
@Autowired
private RoleRepository repo;
@Autowired
private UserRepository userRepo;
	private RoleName name;
	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);}
	
	
	
	
	
	  @Bean CommandLineRunner runner() { return args -> {
	  
				
				  Role adminRole = new Role(name.ADMIN, "Gérer les utilisateurs" +
				  " ,Consulter les voyages" + "et Consulter les réservations des voyages");
				  
				  
				  Role agentAerien = new Role(name.VAGENT_AERIEN,"Ajouter les voyages aériens"
				  + ", Consulter la liste de réservation des voyagemodificationss" +
				  ", Annuler ou modifier la date du voyage ( dans ce cas un email sera envoyé aux personnes qui"
				  + "et ont réservé ce voyage pour les informer de ces )");
				  
				  Role agentMaritime = new
				  Role(name.VAGENT_MARITIME,"Ajouter les voyages maritimes" +
				  ", Consulter la liste de réservation des voyages" +
				  ", Annuler ou modifier la date du voyage ( dans ce cas un email sera envoyé aux personnes qui"
				  + " et ont réservé ce voyage pour les informer de ces modifications)");
				  
				  repo.saveAll(List.of(adminRole, agentAerien, agentMaritime));
				 
	  
	  User user = new User(); user.setFirstname("annabi");
	  user.setEmail("annabi.mabrouka99@gmail.com"); user.setGender("femme");
	  user.setEnabled(true); user.setBirthDate("06/09/1996");
	  user.setLastname("mabrouka") ; user.setCreateAt(new Date()); String password
	  = AES256.encrypt("mabrouka "); user.setPassword(password);
	  user.setRole(adminRole);
	  userRepo.save(user); 
	  user.toString();
	  
	  };
	  
	  }
	 	 }
