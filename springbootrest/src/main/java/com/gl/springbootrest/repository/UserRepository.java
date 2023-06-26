package com.gl.springbootrest.repository;

import com.gl.springbootrest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom repository methods
    User findByName(String name);

    User findByEmail(String email);

    // Additional custom methods...
}
