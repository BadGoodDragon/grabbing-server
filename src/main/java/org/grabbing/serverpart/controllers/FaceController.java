package org.grabbing.serverpart.controllers;

import lombok.RequiredArgsConstructor;
import org.grabbing.serverpart.services.AccountService;
import org.grabbing.serverpart.services.FaceService;
/*import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;*/
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/facemanagement")
public class FaceController {
    private final AccountService accountService;
    private final FaceService faceService;

    @PostMapping("/register")
    private boolean register(@RequestBody String name) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        long id = faceService.register(name);
        if (id == -1) {
            return false;
        }

        return faceService.attach(username, id);
    }

    @PostMapping("/attach")
    private boolean attach(@RequestBody String attachedUsername) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        long id = accountService.getFaceIdByUsername(username);

        return faceService.attach(attachedUsername, id);
    }

    @PostMapping("/detach")
    private boolean detach(@RequestBody String detachedUsername) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        long id = accountService.getFaceIdByUsername(username);

        return faceService.detach(detachedUsername, id);
    }

    @PostMapping("/getcurrentname")
    private String getCurrentName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        long id = accountService.getFaceIdByUsername(username);

        return faceService.getNameById(id);
    }

    @PostMapping("/getlistoflinkedusers")
    private List<String> getListOfLinkedUsers() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        long id = accountService.getFaceIdByUsername(username);
        List<String> list = accountService.getAllByFaceId(id);

        return list;
    }
}
