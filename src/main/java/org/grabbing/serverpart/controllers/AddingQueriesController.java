package org.grabbing.serverpart.controllers;

import lombok.RequiredArgsConstructor;
import org.grabbing.serverpart.services.AccountService;
import org.grabbing.serverpart.services.AddingQueriesService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addingqueries")
public class AddingQueriesController {
    private final AccountService accountService;
    private final AddingQueriesService addingQueriesService;

    @PostMapping("/add")
    private void add(@RequestBody String url) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        long id = accountService.getFaceIdByUsername(username);

        addingQueriesService.addTest(url, id);
    }

    @PostMapping("/get")
    private List<String> get() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        long id = accountService.getFaceIdByUsername(username);

        return addingQueriesService.getTest(id);
    }
}
