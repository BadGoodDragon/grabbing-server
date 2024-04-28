package org.grabbing.serverpart.servicesimpl;

import lombok.RequiredArgsConstructor;
import org.grabbing.serverpart.services.FaceService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FaceServiceImpl implements FaceService {
    @Override
    public boolean register(String username, String password) {
        return false;
    }

    @Override
    public boolean attach(String username) {
        return false;
    }

    @Override
    public boolean detach(String username) {
        return false;
    }
}
