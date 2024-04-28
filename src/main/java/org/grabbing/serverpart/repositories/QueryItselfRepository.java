package org.grabbing.serverpart.repositories;

import org.grabbing.serverpart.entities.QueryItself;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueryItselfRepository extends JpaRepository<QueryItself, Long> {
    void addQuery();
}
