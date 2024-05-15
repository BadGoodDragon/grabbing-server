package org.grabbing.serverpart.servicesimpl;

import lombok.RequiredArgsConstructor;
import org.grabbing.serverpart.repositories.AccountRepository;
import org.grabbing.serverpart.services.AccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public boolean register(String username, String password) {
        if (accountRepository.checkExistence(username)) {
            return false;
        } else {
            accountRepository.register(username, passwordEncoder.encode(password));
            return true;
        }
    }

    @Override
    @Transactional
    public int checkAuthorization(String username) {
        return -1;
    }

    @Transactional
    @Override
    public long getFaceIdByUsername(String username) {
        return accountRepository.getFaceIdByUsername(username);
    }

    @Transactional
    @Override
    public List<String> getAllByFaceId(long faceId) {
        return accountRepository.getAllByFaceId(faceId);
    }
}
