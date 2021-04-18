package com.chootay.mechanicauthenticationservice.models;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MechanicRepository extends CrudRepository<Mechanic, Integer> {
    Optional<Mechanic> findByUsername(String username);
}