package org.grabbing.serverpart.repositories;

import org.grabbing.serverpart.entities.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepository extends JpaRepository<Host, Long> {
    @Query(value = "insert into grabbing.query_host select nextval('grabbing.host_id_seq'), :name, :sampling_frequency, 0", nativeQuery = true)
    Long createHost(@Param("name") String name, @Param("sampling_frequency") Long samplingFrequency);

    @Query(value = "select a.id from grabbing.query_host a where a.host_name = :name", nativeQuery = true)
    Long getIdByName(@Param("name") String name);

    @Query(value = "select exists (select 1 from grabbing.query_host a where a.id = :name)", nativeQuery = true)
    Boolean check(@Param("name") String name);
}
