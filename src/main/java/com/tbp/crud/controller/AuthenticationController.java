package com.tbp.crud.controller;

import com.tbp.crud.entity.User;
import com.tbp.crud.model.AuthenticationRequest;
import com.tbp.crud.model.AuthenticationResponse;
import com.tbp.crud.service.AuthenticationService;
import com.tbp.crud.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class used for registration and authentication of users
 */
@RestController
public class AuthenticationController {

    @Autowired
    private  AuthenticationService authService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    /**
     * Method for registering the user
     * @param request
     * @return message
     */
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody User request
    ) {
        return ResponseEntity.ok(authService.register(request));
    }

    /**
     * Method for authenticating the user
     * @param authRequest
     * @return string
     */
    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthenticationRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
}
