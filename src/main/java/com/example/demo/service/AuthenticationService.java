package com.example.demo.service;


import com.example.demo.JWT.*;
import com.example.demo.model.MyUser;
import com.example.demo.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final MyUserRepository repository;

    private final JwtUtil jwtService;

    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationResponse authenticate(JwtAuthenticateRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = repository.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        //var refreshToken = jwtService.generateRefreshToken(user);
        return JwtAuthenticationResponse.builder()
                .accessToken(jwtToken)
                //.refreshToken(refreshToken)
                .build();
    }

    public JwtAuthenticationResponse register(JwtRegisterRequest request) {
        MyUser user = MyUser.builder()

                .username(request.getUsername())
                .password(new BCryptPasswordEncoder().encode(request.getPassword()))
                .build();
        String jwtToken = jwtService.generateToken(user);
        //String refreshToken = jwtService.generateRefreshToken(user);
        user.setRole("user");
        repository.save(user);
        return JwtAuthenticationResponse.builder()
                .accessToken(jwtToken)
                // .refreshToken(refreshToken)
                .build();
    }


}