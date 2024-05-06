package org.grabbing.serverpart.servicesimpl;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.grabbing.serverpart.dto.MapItemDto;
import org.grabbing.serverpart.dto.QueryOutput;
import org.grabbing.serverpart.dto.QueryTableOutput;
import org.grabbing.serverpart.repositories.MapItemRepository;
import org.grabbing.serverpart.repositories.MapStartRepository;
import org.grabbing.serverpart.repositories.QueryItselfRepository;
import org.grabbing.serverpart.services.QueryReceiptService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class QueryReceiptServiceImpl implements QueryReceiptService {
    private static final long QUANTITY = 5;

    private final QueryItselfRepository queryItselfRepository;
    private final MapStartRepository mapStartRepository;
    private final MapItemRepository mapItemRepository;

    @Override
    public List<QueryOutput> receive() {
        List<QueryOutput> result = new ArrayList<>();

        List<QueryTableOutput> outTable = queryItselfRepository.receive(QUANTITY);

        for (QueryTableOutput queryTableOutput : outTable) {
            List<MapItemDto> parametersList = mapItemRepository
                    .getAllByObjectId(queryTableOutput.getParametersId());
            List<MapItemDto> headersList = mapItemRepository
                    .getAllByObjectId(queryTableOutput.getQueryHeadersId());

            Map<String, String> parameters = new HashMap<>();
            Map<String, String> headers = new HashMap<>();

            for (MapItemDto mapItemDto : parametersList) {
                parameters.put(mapItemDto.getFirst(), mapItemDto.getSecond());
            }
            for (MapItemDto mapItemDto : headersList) {
                headers.put(mapItemDto.getFirst(), mapItemDto.getSecond());
            }

            result.add(QueryOutput.builder()
                    .id(queryTableOutput.getId())
                    .url(queryTableOutput.getUrl())
                    .parameters(parameters)
                    .queryHeaders(headers)
                    .queryBody(queryTableOutput.getQueryBody())
                    .build()
            );
        }

        return result;
    }
}
