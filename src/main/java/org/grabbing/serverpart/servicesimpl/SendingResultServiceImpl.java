package org.grabbing.serverpart.servicesimpl;

import lombok.RequiredArgsConstructor;
import org.grabbing.serverpart.dto.ResponseInput;
import org.grabbing.serverpart.services.SendingResultService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SendingResultServiceImpl implements SendingResultService {
    @Override
    public void send(List<ResponseInput> responseInputList) {

    }
}
