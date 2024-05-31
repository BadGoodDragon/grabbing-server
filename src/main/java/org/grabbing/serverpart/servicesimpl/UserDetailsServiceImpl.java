package org.grabbing.serverpart.servicesimpl;

import lombok.RequiredArgsConstructor;
import org.grabbing.serverpart.repositories.AccountRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = accountRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("Error");
        }

        return user;
    }
}
