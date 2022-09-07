package org.mss.UserManagement.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.mss.UserManagement.model.Role;
import org.mss.UserManagement.model.User;


public interface IUserService {
	
	public User save(User user);

	public List<User> findAll();
	public void delete(String  email);
    public Optional<User> getUserByEmail(String email);
	public User updateUser(String  email, @Valid User user);
public List<Role>getAllRoles();
	public User updateUserEnabled(String id);
public Role getRoleByName(long id);

}
