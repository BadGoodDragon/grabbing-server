package org.grabbing.serverpart.services;

import org.grabbing.serverpart.dto.MyQuery;
import org.grabbing.serverpart.dto.QueryVisual;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Map;

public interface AddingQueriesService {
    void addQuery(long faceId, String url,
                  Map<String, String> parameters,
                  Map<String, String> headers,
                  String body, long hostId);

    List<MyQuery> getDone(long faceId);
    List<MyQuery> getInProcess(long faceId);

    QueryVisual getQuery(long id);
}
