package com.Bgrupo4.hospitalupskill.security.jwt;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserNameAndPasswordAuthenticationRequest {

    private String username;
    private String password;

}
