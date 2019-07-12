package com.hcl.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.mortgage.entity.UserDetails;

/**
 * UserRepository interface represent the user_details table repository
 * @author amol.jadhav
 */
@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer>{

}
