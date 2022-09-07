package org.mss.UserManagement.repository;

import org.mss.UserManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String>{
public User findUserByEmail(String email);
}
