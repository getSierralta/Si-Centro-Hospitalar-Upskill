package com.Bgrupo4.hospitalupskill.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class ApplicationUserController {

    @Autowired
    private ApplicationUserService applicationUserService;

    @GetMapping(path = "{id}")
    public ApplicationUser getUser(@PathVariable("id") Long id){
        return applicationUserService.getUserById(id);
    }
}
