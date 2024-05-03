package org.grabbing.serverpart.controllers;

import lombok.RequiredArgsConstructor;
import org.grabbing.serverpart.services.AccountService;
/*import org.grabbing.serverpart.servicesimpl.AccountServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;*/
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accountmanagement")
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/register")
    private boolean register() {
        /*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        /*String username = authentication.getName();
        String password = (String) authentication.getCredentials();*/

        //return accountService.register(username, password);
        return accountService.register("username", "password");
    }

    @PostMapping("/generatetoken")
    private String generateToken() {
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        //String username = authentication.getName();
        //String password = "pw"; // работает только если
                                    // добавлена система проверки авторизации

        //return accountService.generateToken(username);
        return "fhfgfhfhg";
    }

}
