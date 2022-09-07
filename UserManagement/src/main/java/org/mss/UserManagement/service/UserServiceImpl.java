package org.mss.UserManagement.service;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.codehaus.stax2.ri.typed.ValueDecoderFactory.BaseArrayDecoder;
import org.mss.UserManagement.model.AES256;
import org.mss.UserManagement.model.Role;
import org.mss.UserManagement.model.User;
import org.mss.UserManagement.repository.RoleRepository;
import org.mss.UserManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements  IUserService {
@Autowired
private UserRepository userRepo;

@Autowired
private RoleRepository roleRepo;
@Autowired
private EmailServiceImpl emailService;
@Override
public User save(User user) {
 User userSerched=userRepo.findUserByEmail(user.getEmail());
if(userSerched==null)
{
	return userRepo.save(user);

}
return null;
}

@Override
public List<User> findAll() {
	// TODO Auto-generated method stub
	return userRepo.findAll();
}

@Override
public void delete(String email) {
	// TODO Auto-generated method stub
	userRepo.deleteById(email);
}

@Override
public Optional<User> getUserByEmail(String email) {
	// TODO Auto-generated method stub
	return userRepo.findById(email);
}

@Override
public User updateUser(String email, @Valid User user) {
	Optional<User> userSearched=userRepo.findById(email);
	User userUpdated=userSearched.get();
	userUpdated.setFirstname(user.getFirstname());
	userUpdated.setLastname(user.getLastname());
	userUpdated.setEmail(user.getEmail());
	userUpdated.setGender(user.getGender());
	userUpdated.setBirthDate(user.getBirthDate());
	userUpdated.setEnabled(false);
	userUpdated.setPassword(user.getPassword());
user=userUpdated;
return userRepo.save(user);
}

@Override
public User updateUserEnabled(String id) {
 User userSerched=userRepo.findUserByEmail(id);
if (userSerched.getEnabled()==false)
        {
	   String encryptedString = AES256.decrypt(userSerched.getPassword());

	String msg="Welcome  "+userSerched.getFirstname()+" "+userSerched.getLastname() +" to Mss Consulting you can now log in with your account : \n  email : "+	userSerched.getEmail()+"\n password : "+encryptedString;
    
	userSerched.setEnabled(true);
        
        this.emailService.sendEmail(userSerched.getEmail(),"Account details",msg);;
	    }
else 
	userSerched.setEnabled(false);

return userSerched;
}
	
public List<Role>getAllRoles(){
	return roleRepo.findAll();
}

@Override
public Role getRoleByName(long id) {
	// TODO Auto-generated method stub
	return null;
}
}
