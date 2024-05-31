package org.grabbing.serverpart.servicesimpl;

import lombok.RequiredArgsConstructor;
import org.grabbing.serverpart.repositories.AccountRepository;
import org.grabbing.serverpart.repositories.FaceRepository;
import org.grabbing.serverpart.services.FaceService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class FaceServiceImpl implements FaceService {
    private final FaceRepository faceRepository;
    private final AccountRepository accountRepository;

    @Transactional
    @Override
    public long register(String name) {
        if (!faceRepository.check(name)) {
            faceRepository.register(name);
            return faceRepository.getId(name);
        } else {
            return -1;
        }
    }

    @Transactional
    @Override
    public boolean attach(String username, long faceId) {
        if (faceRepository.check(faceId) && accountRepository.checkExistence(username)) {
            return accountRepository.attachFace(username, faceId);
        } else {
            return false;
        }
    }

    @Transactional
    @Override
    public boolean detach(String username, long faceId) {
        if (faceRepository.check(faceId) && accountRepository.checkExistence(username)) {
            return accountRepository.detachFace(username, faceId);
        } else {
            return false;
        }
    }

    @Transactional
    @Override
    public String getNameById(long faceId) {
        return faceRepository.getName(faceId);
    }

    @Transactional
    @Override
    public boolean check(String username) {
        return accountRepository.hasFace(username);
    }
}
