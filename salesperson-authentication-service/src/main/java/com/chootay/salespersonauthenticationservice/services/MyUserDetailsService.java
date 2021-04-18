package com.chootay.salespersonauthenticationservice.services;

import com.chootay.salespersonauthenticationservice.models.Salesperson;
import com.chootay.salespersonauthenticationservice.models.SalespersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private SalespersonRepository salespersonRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Salesperson> salesperson = salespersonRepository.findByUsername(userName);

        salesperson.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return salesperson.map(MyUserDetails::new).get();
    }
}
