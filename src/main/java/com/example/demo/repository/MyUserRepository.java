package com.example.demo.repository;


import com.example.demo.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Integer> {

    public MyUser findMyUserByUsername(String username);
    public MyUser findUserById(Integer id);

    Optional<MyUser> findByUsername(String Username);
}
