package org.grabbing.serverpart.controllers;

import lombok.RequiredArgsConstructor;
import org.grabbing.serverpart.services.AccountService;
import org.grabbing.serverpart.services.FaceService;
/*import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;*/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/facemanagement")
public class FaceController {
    private final AccountService accountService;
    private final FaceService faceService;

    @PostMapping("/register")
    private boolean register() {
        String username = "username";
        String name = "f_test2";

        long id = faceService.register(name);
        if (id == -1) {
            return false;
        }

        return faceService.attach(username, id);
    }

    @PostMapping("/attach")
    private boolean attach() {
        String username = "username";
        String attachedUsername = "username2";

        long id = accountService.getFaceIdByUsername(username);

        return faceService.attach(attachedUsername, id);
    }

    @PostMapping("/detach")
    private boolean detach() {
        String username = "username";
        String detachedUsername = "username2";

        long id = accountService.getFaceIdByUsername(username);

        return faceService.detach(detachedUsername, id);
    }

    @PostMapping("/getcurrentname")
    private String getCurrentName() {
        String username = "username";

        long id = accountService.getFaceIdByUsername(username);

        return faceService.getNameById(id);
    }

    @PostMapping("/getlistoflinkedusers")
    private List<String> getListOfLinkedUsers() {
        String username = "username";

        long id = accountService.getFaceIdByUsername(username);
        List<String> list = accountService.getAllByFaceId(id);

        return list;
    }
}
