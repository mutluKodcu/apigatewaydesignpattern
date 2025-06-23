package com.uyg2.dmtbkt.apigatewaydesignpattern.userservice.service;

import com.uyg2.dmtbkt.apigatewaydesignpattern.userservice.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();
    Optional<User> findUserById(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
}
