package com.tbp.crud.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthenticationResponse implements Serializable {

    private final String jwt;

    private final String message;
    public AuthenticationResponse(String jwt, String message) {
        this.jwt = jwt;
        this.message = message;
    }
}

