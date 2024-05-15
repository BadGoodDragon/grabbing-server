package org.grabbing.serverpart.services;

public interface FaceService {
    long register(String name);

    boolean attach(String username, long faceId);
    boolean detach(String username, long faceId);

    String getNameById(long faceId);

    boolean check(String username);
}
