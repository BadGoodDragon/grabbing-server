package org.grabbing.serverpart.controllers;

import lombok.RequiredArgsConstructor;
import org.grabbing.serverpart.dto.QueryOutput;
import org.grabbing.serverpart.services.AccountService;
import org.grabbing.serverpart.services.QueryReceiptService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private final AccountService accountService;

    @GetMapping("/receive")
    private List<QueryOutput> receive() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        long id = accountService.getFaceIdByUsername(username);

        return queryReceiptService.receive(id);
    }
}
