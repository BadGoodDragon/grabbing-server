package org.grabbing.serverpart.repositories;

import org.grabbing.serverpart.entities.Account;
import org.grabbing.serverpart.entities.ResponseItself;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseItselfRepository extends JpaRepository<ResponseItself, Long> {
    @Query(value = "insert into grabbing.response_itself (error, status_code, headers_id, body)" +
            "values (:error, :status_code, :headers_id, :body)" +
            "returning id;", nativeQuery = true)
    Long createResponse(@Param("error") Boolean error,
                           @Param("status_code") Integer statusCode,
                           @Param("headers_id") Long headersId,
                           @Param("body") String body);

    @Query(value = "select body from grabbing.response_itself where id = :id", nativeQuery = true)
    String getBodyByIdTest(@Param("id") Long id);
}
