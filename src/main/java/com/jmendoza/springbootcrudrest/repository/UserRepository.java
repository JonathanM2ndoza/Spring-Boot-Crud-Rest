package com.jmendoza.springbootcrudrest.repository;

import com.jmendoza.springbootcrudrest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByFirstName(String firstName);

    Optional<User> findByLastNameAndEmailId(String lastName, String emailId);
}
