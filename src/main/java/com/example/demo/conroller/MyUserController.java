package com.example.demo.conroller;

import com.example.demo.model.MyUser;
import com.example.demo.service.MyUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class MyUserController {

    private final MyUserService myUserService;


    @GetMapping("/get")
    public ResponseEntity getUser() {
        List<MyUser> userList = myUserService.getUsers();
        return ResponseEntity.status(200).body(userList);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid MyUser userModel, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        myUserService.addUser(userModel);
        return ResponseEntity.status(200).body("added");
    }

    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(HttpStatus.OK).body("Welcome back");
    }

    @PostMapping("/logout")
    public ResponseEntity logout(){
        return ResponseEntity.status(HttpStatus.OK).body("logout!");
    }

    @GetMapping("/getUser")
    public ResponseEntity getUserById(@AuthenticationPrincipal MyUser user){
        return ResponseEntity.status(HttpStatus.OK).body(myUserService.getUserById(user.getId()));

    }
}
