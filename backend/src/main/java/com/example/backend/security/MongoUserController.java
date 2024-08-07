package com.example.backend.security;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class MongoUserController {

    private final MongoUserDetailsService service;

    @GetMapping
    public String getMe(){
        return SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
    }

    @PostMapping("/login")
    public String login(){
        return SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
    }

    @PostMapping("/register")
    public void register(@RequestBody MongoUserDTO newUser){
        service.registerNewUser(newUser);
    }

    @GetMapping("/logout")
    public void logout(HttpSession session){
        //Session beenden!
        session.invalidate();
        //SecurityContext löschen
        SecurityContextHolder.clearContext();
    }
}
