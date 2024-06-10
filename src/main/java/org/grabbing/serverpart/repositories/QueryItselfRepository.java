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

    @Query(value = "INSERT INTO grabbing.query_itself" +
            " (url, host_id, parameters_id, headers_id, body, is_has_response, response_id, face_id, enabled)" +
            " VALUES(:url, :host_id, :parameters_id, :headers_id, :body, false, 0, :face_id, true) returning id", nativeQuery = true)
    Long addQuery(@Param("url") String url, @Param("host_id") Long hostId,
                  @Param("parameters_id") Long parametersId, @Param("headers_id") Long headersId,
                  @Param("body") String body, @Param("face_id") Long faceId);

    @Query(value = "select id from grabbing.query_itself where face_id = :face_id and is_has_response = true", nativeQuery = true)
    List<Long> getDone(@Param("face_id") Long faceId);

    @Query(value = "select id from grabbing.query_itself where face_id = :face_id and is_has_response = false", nativeQuery = true)
    List<Long> getInProcess(@Param("face_id") Long faceId);


    @Query(value = "select url from grabbing.query_itself where id = :id", nativeQuery = true)
    String getUrl(@Param("id") Long id);
    @Query(value = "select parameters_id from grabbing.query_itself where id = :id", nativeQuery = true)
    Long getParametersId(@Param("id") Long id);
    @Query(value = "select headers_id from grabbing.query_itself where id = :id", nativeQuery = true)
    Long getHeadersId(@Param("id") Long id);
    @Query(value = "select body from grabbing.query_itself where id = :id", nativeQuery = true)
    String getBody(@Param("id") Long id);
    @Query(value = "select is_has_response from grabbing.query_itself where id = :id", nativeQuery = true)
    Boolean getIsHasResponse(@Param("id") Long id);
    @Query(value = "select response_id from grabbing.query_itself where id = :id", nativeQuery = true)
    Long getResponseId(@Param("id") Long id);

}