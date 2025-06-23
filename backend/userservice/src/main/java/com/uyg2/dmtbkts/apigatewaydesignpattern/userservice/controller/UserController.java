package com.uyg2.dmtbkt.apigatewaydesignpattern.userservice.controller;

import com.uyg2.dmtbkt.apigatewaydesignpattern.userservice.entity.User;
import com.uyg2.dmtbkt.apigatewaydesignpattern.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.findUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
	@GetMapping("/whoami")
	public ResponseEntity<String> whoAmI(@RequestHeader("X-User-Name") String username) {
		return ResponseEntity.ok("Hoşgeldin " + username);
	}
}
