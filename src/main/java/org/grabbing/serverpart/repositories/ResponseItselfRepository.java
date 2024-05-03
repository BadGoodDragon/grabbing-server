package org.grabbing.serverpart.repositories;

import org.grabbing.serverpart.entities.Account;
import org.grabbing.serverpart.entities.ResponseItself;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseItselfRepository extends JpaRepository<ResponseItself, Long> {

}
