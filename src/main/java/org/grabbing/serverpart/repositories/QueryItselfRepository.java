package org.grabbing.serverpart.repositories;

import org.grabbing.serverpart.entities.QueryItself;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryItselfRepository extends JpaRepository<QueryItself, Long> {

}
