package com.taskTracker.ai.controller;

import org.springframework.web.bind.annotation.*;

        import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {

        String username = request.get("username");
        String password = request.get("password");

        if(username.equals("admin") && password.equals("admin")) {

            return Map.of(
                    "token",
                    "dummy-jwt-token"
            );
        }

        throw new RuntimeException("Invalid Credentials");
    }
}