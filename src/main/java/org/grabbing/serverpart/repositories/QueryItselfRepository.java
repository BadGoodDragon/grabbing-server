package org.grabbing.serverpart.repositories;

import org.grabbing.serverpart.dto.QueryTableOutput;
import org.grabbing.serverpart.entities.QueryItself;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueryItselfRepository extends JpaRepository<QueryItself, Long> {
    @Query(value = "select id as id, url as url, parameters_id as parametersId, headers_id as queryHeadersId, body as queryBody from grabbing.receive(:quantity)", nativeQuery = true)
    List<QueryTableOutput> receive(@Param("quantity") Long quantity);

    @Query(value = "update grabbing.query_itself " +
            "set is_has_response=true, response_id=:response_id " +
            "where id=:id and is_has_response=false " +
            "returning query_itself.id", nativeQuery = true)
    Long addResponse(@Param("id") Long id, @Param("response_id") Long responseId);

    @Query(value = "INSERT INTO grabbing.query_itself (url, host_id, parameters_id, headers_id, body, is_has_response, response_id, face_id, enabled) VALUES(:url, 2, 0, 0, '', false, 0, :face_id, true) returning id", nativeQuery = true)
    Long createTest(@Param("url") String url, @Param("face_id") Long faceId);

    @Query(value = "select id from grabbing.query_itself where face_id = :face_id", nativeQuery = true)
    List<Long> getByFaceIdTest(@Param("face_id") Long faceId);

    @Query(value = "select url from grabbing.query_itself where id = :id", nativeQuery = true)
    String getUrlByIdTest(@Param("id") Long id);

    @Query(value = "select response_id from grabbing.query_itself where id = :id", nativeQuery = true)
    Long getResponseIdTest(@Param("id") Long id);
}
