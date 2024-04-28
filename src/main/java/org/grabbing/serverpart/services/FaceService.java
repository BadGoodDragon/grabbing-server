package org.grabbing.serverpart.services;

public interface FaceService {
    boolean register(String username, String password);

    boolean attach(String username);
    boolean detach(String username);
}
