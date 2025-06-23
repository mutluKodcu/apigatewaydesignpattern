package com.uyg2.dmtbkt.apigatewaydesignpattern.userservice.repository;

import com.uyg2.dmtbkt.apigatewaydesignpattern.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}