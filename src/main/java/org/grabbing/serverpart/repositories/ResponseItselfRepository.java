package org.grabbing.serverpart.repositories;

import org.grabbing.serverpart.entities.Account;
import org.grabbing.serverpart.entities.ResponseItself;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseItselfRepository extends JpaRepository<ResponseItself, Long> {
}
