package com.Bgrupo4.hospitalupskill.repositories;

import com.Bgrupo4.hospitalupskill.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByDescription(String name);

    @Query(value = "SELECT * FROM Pessoa", nativeQuery = true)
    List<User> customQuery(String name);
}
