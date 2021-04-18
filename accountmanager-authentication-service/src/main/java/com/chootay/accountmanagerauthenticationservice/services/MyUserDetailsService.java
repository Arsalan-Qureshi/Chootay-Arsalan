package com.chootay.accountmanagerauthenticationservice.services;

import com.chootay.accountmanagerauthenticationservice.models.AccountManager;
import com.chootay.accountmanagerauthenticationservice.models.AccountManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountManagerRepository accountmanagerRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<AccountManager> accountmanager = accountmanagerRepository.findByUsername(userName);

        accountmanager.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return accountmanager.map(MyUserDetails::new).get();
    }
}
