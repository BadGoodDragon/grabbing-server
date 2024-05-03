package org.grabbing.serverpart.services;

import java.util.List;

public interface AccountService {
    boolean register(String username, String password);
    int checkAuthorization(String username);
    long getFaceIdByUsername(String username);
    List<String> getAllByFaceId(long faceId);
}
