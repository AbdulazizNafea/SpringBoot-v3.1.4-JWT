package com.example.demo.conroller;

import com.example.demo.JWT.*;
import com.example.demo.model.MyUser;
import com.example.demo.repository.MyUserRepository;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.LogoutService;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;
    private final LogoutService logoutService;



    @PostMapping("/register")
    public ResponseEntity<JwtAuthenticationResponse> register(@RequestBody JwtRegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> authenticate(@RequestBody JwtAuthenticateRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }



    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, java.io.IOException {
        authenticationService.refreshToken(request, response);
    }

    @GetMapping("/get")
    public ResponseEntity register(){
        return ResponseEntity.status(200).body("Hala Wallah");
    }


}
