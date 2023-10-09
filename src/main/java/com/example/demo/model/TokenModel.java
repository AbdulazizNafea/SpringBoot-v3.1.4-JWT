package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TokenModel {
    @Id
    @GeneratedValue
    public Integer id;

    @Column(unique = true)
    public String token;

    @Enumerated(EnumType.STRING)
    public TokenType tokenType = TokenType.BEARER;

    public boolean revoked;

    public boolean expired;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "myUser")
//    public MyUser myUser;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName ="id")
    @JsonIgnore
    public MyUser myUser;
}

