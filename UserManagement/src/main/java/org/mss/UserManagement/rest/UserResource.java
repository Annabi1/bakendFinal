package org.mss.UserManagement.rest;

import java.net.URI

;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.mss.UserManagement.model.AES256;
import org.mss.UserManagement.model.Role;
import org.mss.UserManagement.model.User;
import org.mss.UserManagement.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserResource {
	  private final Logger log = LoggerFactory.getLogger(UserResource.class);
		private  final IUserService service;
	 
	 public UserResource(IUserService service) {
			super();
			this.service = service;
		}

	@GetMapping("/")
	    public  List<User> getAllUsers() {
	        log.debug("REST request to get all user");
	        return service.findAll();
	    }
	@GetMapping("/roles")
    public  List<Role> getAllRoles() {
        return service.getAllRoles();
    }
	@GetMapping("/roles/{id}")
    public  ResponseEntity<Role> getRoleById(@PathVariable long id) {
        Role role= service.getRoleByName(id);
        return ResponseEntity.ok()
                .body(role);
    }


		/*
		 * @GetMapping("/userByElmail") public ResponseEntity<User>
		 * getUser(@RequestParam(name="email")String email) {
		 * log.debug("REST request to get User : {}", email); Optional< User> user =
		 * service.getUserByEmail(email); return ResponseEntity.ok().body(user.get()); }
		 */

	
	

	@PostMapping("/")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) throws URISyntaxException {
        log.debug("REST request to save user : {}", user);
   user.setCreateAt(new Date());
   String encryptedString = AES256.encrypt(user.getPassword());

   user.setPassword(encryptedString);
   user.setEnabled(false);
        User result = service.save(user);
        return ResponseEntity.created(new URI("/api/users/" + result))
                .body(result);
    }
	@GetMapping("/{id}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String id) {
        log.debug("REST request to get User : {}", id);
       Optional< User> user = service.getUserByEmail(id);
        return ResponseEntity.ok().body(user.get());
    }
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        log.debug("REST request to delete user : {}", id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

	/*
	 * @PutMapping("/{id}") public ResponseEntity<User> updateUser( @PathVariable
	 * String id ,@Valid @RequestBody User user) throws URISyntaxException {
	 * log.debug("REST request to update user : {}", user);
	 * 
	 * User result = service.updateUser(id,user); return ResponseEntity.ok()
	 * .body(result); }
	 */    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserEnabled(   @PathVariable String id,@Valid @RequestBody User user ) throws URISyntaxException {

        User result = service.updateUserEnabled(id);
        return ResponseEntity.ok()
                .body(result);
    }


}
