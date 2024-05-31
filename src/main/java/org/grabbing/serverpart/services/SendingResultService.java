package org.grabbing.serverpart.services;

import org.grabbing.serverpart.dto.ResponseInput;

import java.util.List;

public interface SendingResultService {
    void send(List<ResponseInput> responseInputList);
}
