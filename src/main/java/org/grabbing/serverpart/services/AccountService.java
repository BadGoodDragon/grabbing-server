package org.grabbing.serverpart.services;

public interface AccountService {
    boolean register(String username, String password);
    String generateToken(String username);
    int checkAuthorization(String token);
}
