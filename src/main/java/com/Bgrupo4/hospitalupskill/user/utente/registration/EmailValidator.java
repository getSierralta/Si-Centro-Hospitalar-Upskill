package com.Bgrupo4.hospitalupskill.user.utente.registration;


import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {

    @Override
    public boolean test(String s) {
        //Todo regex to validade email
        return true;
    }
}
