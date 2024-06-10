package org.grabbing.serverpart.controllers;

import lombok.RequiredArgsConstructor;
import org.grabbing.serverpart.dto.MyQuery;
import org.grabbing.serverpart.dto.NewQuery;
import org.grabbing.serverpart.dto.QueryVisual;
import org.grabbing.serverpart.services.AccountService;
import org.grabbing.serverpart.services.AddingQueriesService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addingqueries")
public class AddingQueriesController {
    private final AccountService accountService;
    private final AddingQueriesService addingQueriesService;

    @PostMapping("/add")
    private void addQuery(@RequestBody NewQuery newQuery) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        long id = accountService.getFaceIdByUsername(username);

        addingQueriesService.addQuery(id, newQuery.getUrl(),
                newQuery.getParameters(),
                newQuery.getHeaders(),
                newQuery.getBody(),
                newQuery.getHostId());
    }

    @GetMapping("/getdone")
    private List<MyQuery> getDone() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        long id = accountService.getFaceIdByUsername(username);

        return addingQueriesService.getDone(id);
    }

    @GetMapping("/getinprocess")
    private List<MyQuery> getInProcess() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        long id = accountService.getFaceIdByUsername(username);

        return addingQueriesService.getInProcess(id);
    }

    @GetMapping("/getquery")
    private QueryVisual getQuery(@RequestHeader("X-ID") Long id) {

        return addingQueriesService.getQuery(id);
    }
}
