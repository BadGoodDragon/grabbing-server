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
    Integer addResponse(@Param("id") Long id, @Param("response_id") Long responseId);
}
