package com.Bgrupo4.hospitalupskill.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/users")
public class UserManagementController {

    private static final List<User> USERS = Arrays.asList(
            new User(123, "João"),
            new User(1000, "Max"),
            new User(526, "Gabriel"),
            new User(154, "Thiago")
    );

    @GetMapping
    //@PreAuthorize("Respect mah authority!")
    public List<User> getAllUsers(){
        System.out.println("getAllUsers");
        return USERS;
    }

    @PostMapping
    //@PreAuthorize("Respect mah authority!")
    public void registerNewUser(@RequestBody User user) {
        System.out.println("postUser");
        System.out.println(user);
    }

    @DeleteMapping(path = "{utente}")
    //@PreAuthorize("Respect mah authority!")
    public void deleteUser(@PathVariable("utente") Integer utente){
        System.out.println("deleteUser");
        System.out.println(utente);
    }

    @PutMapping(path = "{utente}")
    //@PreAuthorize("Respect mah authority!")
    public void updateUser(@PathVariable("utente") Integer utente, @RequestBody User user) {
        System.out.println("updateUser");
        System.out.printf("%s %s%n", utente, user);

    }




}
