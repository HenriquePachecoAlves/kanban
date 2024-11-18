package com.novo.projeto.controller;

import com.novo.projeto.config.TokenUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenUtility tokenUtility;

    @PostMapping("/signin")
    public String signIn(@RequestBody AuthRequest request) throws Exception {
        try {
            Authentication auth = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
            return tokenUtility.createToken(request.getUsername());
        } catch (AuthenticationException e) {
            throw new Exception("Invalid login details");
        }
    }
}