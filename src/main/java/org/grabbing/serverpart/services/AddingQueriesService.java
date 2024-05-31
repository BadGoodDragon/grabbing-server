package org.grabbing.serverpart.services;

import java.util.List;

public interface AddingQueriesService {
    void addTest(String url, long faceId);
    List<String> getTest(long faceId);
}
