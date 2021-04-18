package com.chootay.accountmanagerauthenticationservice.models;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountManagerRepository extends CrudRepository<AccountManager, Integer> {
    Optional<AccountManager> findByUsername(String username);
}