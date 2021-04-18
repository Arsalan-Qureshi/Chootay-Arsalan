package com.chootay.salespersonservice.models;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SalespersonRepository extends CrudRepository<Salesperson, Integer> {
    Optional<Salesperson> findByUsername(String username);
}