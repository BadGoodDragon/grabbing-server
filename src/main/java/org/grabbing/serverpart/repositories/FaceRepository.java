package org.grabbing.serverpart.repositories;

import org.grabbing.serverpart.entities.Account;
import org.grabbing.serverpart.entities.Face;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FaceRepository extends JpaRepository<Face, Long> {
    @Query("TODO : write sql query")
    Face add(@Param("name") String name);
    @Query("TODO : write sql query")
    Boolean check(@Param("name") String name);
    @Query("TODO : write sql query")
    Long getId(@Param("name") String name);
}
