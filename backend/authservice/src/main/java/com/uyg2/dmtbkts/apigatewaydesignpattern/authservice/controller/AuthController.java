package com.uyg2.dmtbkt.apigatewaydesignpattern.authservice.controller;

import com.uyg2.dmtbkt.apigatewaydesignpattern.authservice.dto.AuthRequest;
import com.uyg2.dmtbkt.apigatewaydesignpattern.authservice.dto.AuthResponse;
import com.uyg2.dmtbkt.apigatewaydesignpattern.authservice.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        if ("demo".equals(request.getUsername()) && "demo123".equals(request.getPassword())) {
            String token = jwtUtil.generateToken(request.getUsername());
            return ResponseEntity.ok(new AuthResponse(token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Geçersiz kullanıcı adı veya şifre.");
        }
    }
}
