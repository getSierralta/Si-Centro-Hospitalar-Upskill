package com.Bgrupo4.hospitalupskill.user;

import java.util.Optional;

public interface ApplicationUserDao {

    Optional<ApplicationUser> selectUserByUsername(String username);
}
