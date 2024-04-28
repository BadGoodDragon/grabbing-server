package org.grabbing.serverpart.servicesimpl;

import lombok.RequiredArgsConstructor;
import org.grabbing.serverpart.dto.QueryOutput;
import org.grabbing.serverpart.services.QueryReceiptService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryReceiptServiceImpl implements QueryReceiptService {
    @Override
    public List<QueryOutput> receive() {
        return List.of();
    }
}
