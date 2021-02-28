package com.Bgrupo4.hospitalupskill.services;
import com.Bgrupo4.hospitalupskill.domain.Marcacao;
import com.Bgrupo4.hospitalupskill.domain.User;
import com.Bgrupo4.hospitalupskill.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    UserRepository userRepository;

    List<User> users;
    {
        assert false;
        users = userRepository.findAll();
    }

    @Override
    public List<User> getUsers() {
        return users;
    }
}
