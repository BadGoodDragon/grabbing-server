package org.grabbing.serverpart.repositories;

import org.grabbing.serverpart.entities.Account;
import org.grabbing.serverpart.entities.Face;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaceRepository extends JpaRepository<Face, Long> {
    @Query(value = "select count(*) from grabbing.create_face(:name);", nativeQuery = true)
    void register(@Param("name") String name);

    @Query(value = "select exists (select 1 from grabbing.face a where a.face_name = :name)", nativeQuery = true)
    Boolean check(@Param("name") String name);

    @Query(value = "select exists (select 1 from grabbing.face a where a.id = :id)", nativeQuery = true)
    Boolean check(@Param("id") Long id);

    @Query(value = "select a.id from grabbing.face a where a.face_name = :name", nativeQuery = true)
    Long getId(@Param("name") String name);

    @Query(value = "select a.face_name from grabbing.face a where a.id = :id", nativeQuery = true)
    String getName(@Param("id") Long id);
}
