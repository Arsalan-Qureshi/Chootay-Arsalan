package com.chootay.adminauthenticationservice.services;

import com.chootay.adminauthenticationservice.models.Admin;
import com.chootay.adminauthenticationservice.models.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Admin> admin = adminRepository.findByUsername(userName);

        admin.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return admin.map(MyUserDetails::new).get();
    }
}
