package com.example.demo.repository;

import com.example.demo.model.TokenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface TokenRepository extends JpaRepository<TokenModel, Integer> {

    @Query(value = """
      select t from TokenModel t inner join MyUser u\s
      on t.myUser.id = u.id\s
      where u.id = :id and (t.expired = false or t.revoked = false)\s
      """)
    List<TokenModel> findAllValidTokenByMyUser(Integer id);
    Optional<TokenModel> findByToken(String token);
}
