package com.Bgrupo4.hospitalupskill.jwt;

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
