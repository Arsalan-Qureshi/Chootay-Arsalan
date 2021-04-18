package com.chootay.mechanicauthenticationservice.services;

import com.chootay.mechanicauthenticationservice.models.Mechanic;
import com.chootay.mechanicauthenticationservice.models.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private MechanicRepository mechanicRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Mechanic> mechanic = mechanicRepository.findByUsername(userName);

        mechanic.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return mechanic.map(MyUserDetails::new).get();
    }
}
