package org.grabbing.serverpart.controllers;

import com.sun.xml.bind.v2.TODO;
import lombok.RequiredArgsConstructor;
import org.grabbing.serverpart.dto.ResponseInput;
import org.grabbing.serverpart.services.FaceService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/checkmanagement")
public class CheckController {
    private final FaceService faceService;


    @PostMapping("/check")
    private int check() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        if (faceService.check(username)) {
            return 3;
        } else  {
            return 1;
        }
    }
}
