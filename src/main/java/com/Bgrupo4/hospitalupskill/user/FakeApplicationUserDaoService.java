package com.Bgrupo4.hospitalupskill.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Optional;


@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers(){
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(
                        "utente",
                        passwordEncoder.encode("root"),
                        true,
                        true,
                        true,
                        true),
                new ApplicationUser(
                        "medico",
                        passwordEncoder.encode("root"),
                        true,
                        true,
                        true,
                        true),
                new ApplicationUser(
                        "responsavel",
                        passwordEncoder.encode("root"),
                        true,
                        true,
                        true,
                        true),
                new ApplicationUser(
                        "colaborador",
                        passwordEncoder.encode("root"),
                        true,
                        true,
                        true,
                        true),
                new ApplicationUser(
                        "admin",
                        passwordEncoder.encode("root"),
                        true,
                        true,
                        true,
                        true)
        );
        return applicationUsers;
    }
}