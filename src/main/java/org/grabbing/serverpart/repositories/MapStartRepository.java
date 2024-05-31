package org.grabbing.serverpart.repositories;

import org.grabbing.serverpart.entities.MapStart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MapStartRepository extends JpaRepository<MapStart, Long> {
    @Query(value = "insert into grabbing.map_start select nextval('grabbing.map_start_id_seq'), :name returning map_start.id", nativeQuery = true)
    Long createMap(@Param("name") String name);

    @Query(value = "select a.map_name from grabbing.map_start a where a.id = :id", nativeQuery = true)
    String getNameById(@Param("id") Long id);
}
