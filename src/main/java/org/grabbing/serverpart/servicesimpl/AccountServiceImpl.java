package org.grabbing.serverpart.servicesimpl;

import lombok.RequiredArgsConstructor;
import org.grabbing.serverpart.repositories.AccountRepository;
import org.grabbing.serverpart.services.AccountService;
import org.grabbing.serverpart.utilities.TokenGenerator;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public boolean register(String username, String password) {
        if (accountRepository.checkExistence(username)) {
            return false;
        } else {
            accountRepository.register(username, password);
            return true;
        }
    }

    @Override
    @Transactional
    public String generateToken(String username) {
        String token = TokenGenerator.generate(256);
        accountRepository.setToken(username, token);
        return token;
    }

    @Override
    @Transactional
    public int checkAuthorization(String token) {
        return 0;
    }
}
