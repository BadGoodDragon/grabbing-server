package org.grabbing.serverpart.repositories;

import org.grabbing.serverpart.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("TODO : write sql query")
    void register(@Param("username") String username, @Param("password") String password);

    @Query("TODO : write sql query")
    boolean checkExistence(@Param("username") String username);


    @Query("TODO : write sql query")
    boolean setToken(@Param("username") String username, @Param("token") String token);


    @Query("TODO : write sql query")
    boolean verifyToken(@Param("token") String token);

    @Query("TODO : write sql query")
    boolean hasFace(@Param("token") String token);
}
