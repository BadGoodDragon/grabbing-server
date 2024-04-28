package org.grabbing.serverpart.repositories;

import org.grabbing.serverpart.entities.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HostRepository extends JpaRepository<Host, Long> {
    @Query("TODO : write sql query")
    Host getHost();
    @Query("TODO : write sql query")
    Long getIdByName(@Param("name") String name);
}
