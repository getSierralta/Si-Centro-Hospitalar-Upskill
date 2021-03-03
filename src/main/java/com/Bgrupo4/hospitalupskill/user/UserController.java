package com.Bgrupo4.hospitalupskill.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final List<User> USERS = Arrays.asList(
            new User(123, "João"),
            new User(1000, "Max"),
            new User(526, "Gabriel"),
            new User(154, "Thiago")
    );

    @GetMapping(path = "{utente}")
    public User getUser(@PathVariable("utente") Integer utente){
        return USERS.stream().filter(student -> utente.equals(student.getNif())).findFirst()
                .orElseThrow(() -> new IllegalStateException("Utente "+ utente + " does not exists"));


    }
}
