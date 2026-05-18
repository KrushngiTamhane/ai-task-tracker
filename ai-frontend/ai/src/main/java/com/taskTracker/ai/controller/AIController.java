package com.taskTracker.ai.controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AIController {

    @GetMapping("/ai-suggestion")
    public String generateSuggestion(
            @RequestParam String title
    ) {

        if(title.toLowerCase().contains("login")) {

            return "User is unable to login into the application. "
                    + "Need to validate authentication flow, "
                    + "credentials and backend API response.";
        }

        if(title.toLowerCase().contains("payment")) {

            return "Payment transaction is failing for users. "
                    + "Need to verify payment gateway integration "
                    + "and error handling.";
        }

        if(title.toLowerCase().contains("bug")) {

            return "Application contains unexpected behaviour. "
                    + "Need to debug issue and verify logs.";
        }

        return "AI generated description for issue: " + title;
    }
}