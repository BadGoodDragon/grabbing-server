package org.grabbing.serverpart.controllers;

import lombok.RequiredArgsConstructor;
import org.grabbing.serverpart.services.AccountService;
import org.grabbing.serverpart.servicesimpl.AccountServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accountmanagement")
public class AccountController {
    private final AccountServiceImpl accountService;

    @GetMapping("/register")
    private boolean register() {
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    }
}
