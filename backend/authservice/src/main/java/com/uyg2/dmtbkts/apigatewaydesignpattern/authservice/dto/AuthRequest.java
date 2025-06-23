package com.uyg2.dmtbkt.apigatewaydesignpattern.authservice.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
