package org.grabbing.serverpart.servicesimpl;

import lombok.RequiredArgsConstructor;
import org.grabbing.serverpart.dto.MapItemDto;
import org.grabbing.serverpart.dto.MyQuery;
import org.grabbing.serverpart.dto.QueryVisual;
import org.grabbing.serverpart.repositories.*;
import org.grabbing.serverpart.services.AddingQueriesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AddingQueriesServiceImpl implements AddingQueriesService {
    private final QueryItselfRepository queryItselfRepository;
    private final ResponseItselfRepository responseItselfRepository;
    private final MapStartRepository mapStartRepository;
    private final MapItemRepository mapItemRepository;


    @Override
    public void addQuery(long faceId, String url,
                         Map<String, String> parameters,
                         Map<String, String> headers,
                         String body, long hostId) {
        long parametersId = mapStartRepository.createMap("query_parameters");
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            mapItemRepository.create(parametersId, entry.getKey(), entry.getValue());
        }

        long headersId = mapStartRepository.createMap("query_headers");
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            mapItemRepository.create(headersId, entry.getKey(), entry.getValue());
        }

        queryItselfRepository.addQuery(url, hostId, parametersId, headersId, body, faceId);
    }

    @Override
    public List<MyQuery> getDone(long faceId) {
        List<Long> list = queryItselfRepository.getDone(faceId);

        List<MyQuery> result = new ArrayList<>();
        for (Long i : list) {
            result.add(new MyQuery(queryItselfRepository.getUrl(i), i));
        }

        return result;
    }

    @Override
    public List<MyQuery> getInProcess(long faceId) {
        List<Long> list = queryItselfRepository.getInProcess(faceId);

        List<MyQuery> result = new ArrayList<>();
        for (Long i : list) {
            result.add(new MyQuery(queryItselfRepository.getUrl(i), i));
        }

        return result;
    }

    @Override
    public QueryVisual getQuery(long id) {
        Map<String, String> queryParameters = new HashMap<>();
        Map<String, String> queryHeaders = new HashMap<>();

        for (MapItemDto mapItemDto : mapItemRepository.getAllByObjectId(queryItselfRepository.getParametersId(id))) {
            queryParameters.put(mapItemDto.getFirst(), mapItemDto.getSecond());
        }
        for (MapItemDto mapItemDto : mapItemRepository.getAllByObjectId(queryItselfRepository.getHeadersId(id))) {
            queryHeaders.put(mapItemDto.getFirst(), mapItemDto.getSecond());
        }

        if (!queryItselfRepository.getIsHasResponse(id)) {
            return new QueryVisual(queryItselfRepository.getUrl(id),
                    queryParameters, queryHeaders,
                    queryItselfRepository.getBody(id),
                    -1,
                    new HashMap<>(), "",
                    false, false);
        } else {
            long responseId = queryItselfRepository.getResponseId(id);

            if (responseItselfRepository.getError(responseId)) {
                return new QueryVisual(queryItselfRepository.getUrl(id),
                        queryParameters, queryHeaders,
                        queryItselfRepository.getBody(id),
                        -1,
                        new HashMap<>(), "",
                        true, true);
            } else {
                Map<String, String> responseHeaders = new HashMap<>();
                for (MapItemDto mapItemDto : mapItemRepository.getAllByObjectId(responseItselfRepository.getHeadersId(responseId))) {
                    responseHeaders.put(mapItemDto.getFirst(), mapItemDto.getSecond());
                }

                return new QueryVisual(queryItselfRepository.getUrl(id),
                        queryParameters, queryHeaders,
                        queryItselfRepository.getBody(id),
                        responseItselfRepository.getStatusCode(responseId),
                        responseHeaders, responseItselfRepository.getBody(responseId),
                        true, false);
            }
        }
    }
}
