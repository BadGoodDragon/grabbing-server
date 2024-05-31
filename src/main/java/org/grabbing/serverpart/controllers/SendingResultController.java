package org.grabbing.serverpart.controllers;

import lombok.RequiredArgsConstructor;
import org.grabbing.serverpart.dto.QueryOutput;
import org.grabbing.serverpart.dto.ResponseInput;
import org.grabbing.serverpart.services.SendingResultService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/returningresults")
public class SendingResultController {
    private final SendingResultService sendingResultService;

    @PostMapping("/send")
    private void send(@RequestBody List<ResponseInput> inputs) {
        sendingResultService.send(inputs);
    }
}
