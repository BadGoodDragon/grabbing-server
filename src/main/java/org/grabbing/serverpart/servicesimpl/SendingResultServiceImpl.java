package org.grabbing.serverpart.servicesimpl;

import lombok.RequiredArgsConstructor;
import org.grabbing.serverpart.dto.ResponseInput;
import org.grabbing.serverpart.repositories.MapItemRepository;
import org.grabbing.serverpart.repositories.MapStartRepository;
import org.grabbing.serverpart.repositories.QueryItselfRepository;
import org.grabbing.serverpart.repositories.ResponseItselfRepository;
import org.grabbing.serverpart.services.SendingResultService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SendingResultServiceImpl implements SendingResultService {
    private final QueryItselfRepository queryItselfRepository;
    private final ResponseItselfRepository responseItselfRepository;
    private final MapStartRepository mapStartRepository;
    private final MapItemRepository mapItemRepository;

    @Override
    public void send(List<ResponseInput> responseInputList) {
        for (ResponseInput responseInput : responseInputList) {
            Map<String, String> responseHeaders = responseInput.getResponseHeaders();

            long id = mapStartRepository.createMap("response_headers");
            for (Map.Entry<String, String> entry : responseHeaders.entrySet()) {
                mapItemRepository.create(id, entry.getKey(), entry.getValue());
            }

            long responseId = responseItselfRepository.createResponse(
                    responseInput.isError(),
                    responseInput.getStatusCode(),
                    id,
                    responseInput.getResponseBody()
            );

            queryItselfRepository.addResponse(
                    responseInput.getId(),
                    responseId
            );
        }
    }
}
