package org.grabbing.serverpart.controllers;

import lombok.RequiredArgsConstructor;
import org.grabbing.serverpart.dto.QueryOutput;
import org.grabbing.serverpart.services.QueryReceiptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/receivingqueries")
public class ReceivingQueriesController {
    private final QueryReceiptService queryReceiptService;

    @GetMapping("/receive")
    private List<QueryOutput> receive() {
        return queryReceiptService.receive();
    }
}
