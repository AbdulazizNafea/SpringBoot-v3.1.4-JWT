package com.example.demo.service;

import com.example.demo.apiException.ApiException;
import com.example.demo.model.MyUser;
import com.example.demo.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserService {

    private final MyUserRepository myUserRepository;

    public List<MyUser> getUsers() {
        return myUserRepository.findAll();
    }

    //get user by id
    public MyUser getUserById(Integer userId){
        MyUser user = myUserRepository.findUserById(userId);
        if (user.getId() == null) {
            throw new ApiException("user not found");
        }else if (user.getId() != userId) {
            throw new ApiException(" not allow to get user");
        }
        return user;
    }

    public void addUser(MyUser myUser) {
        myUser.setPassword(new BCryptPasswordEncoder().encode(myUser.getPassword()));
        myUser.setRole("user");
        myUserRepository.save(myUser);
    }


}
