package org.grabbing.serverpart.services;

import org.grabbing.serverpart.dto.QueryOutput;

import java.util.List;

public interface QueryReceiptService {
    List<QueryOutput> receive();
}
