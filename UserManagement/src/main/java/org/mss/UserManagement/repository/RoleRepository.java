package org.mss.UserManagement.repository;

import org.mss.UserManagement.model.Role;
import org.mss.UserManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
