package com.chootay.accountmanagerservice.services;

import com.chootay.accountmanagerservice.models.AccountManager;
import com.chootay.accountmanagerservice.models.AccountManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class AccountManagerService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AccountManagerRepository accountmanagerRepository;

    public AccountManagerService() {
    }

    public Iterable<AccountManager> getAllAccountManagers(String token) {
        if (authenticateAccountManager(token).matches("OK")) {
            Iterable<AccountManager> accountmanagers = accountmanagerRepository.findAll();
            return accountmanagers;
        } else {
            return null;
        }
    }

//    public List<AccountManager> getAll() {
//        List<AccountManager> list = new ArrayList<>();
//        accountmanagerRepository.findAll().iterator().forEachRemaining(list::add);
//        return list;
//    }

//    public Optional<AccountManager> getAccountManagerByUsername(String token, String userName) {
//        if (authenticateAccountManager(token).matches("OK")) {
//            return accountmanagerRepository.findByUserName(userName);
//        } else {
//            return null;
//        }
//    }

    public Optional<AccountManager> getAccountManager(String token, Integer id) {
        if (authenticateAccountManager(token).matches("OK")) {
            return accountmanagerRepository.findById(id);
        } else {
            return null;
        }

    }

    public void addAccountManager(String token, AccountManager accountmanager) {
        if (authenticateAccountManager(token).matches("OK")) {
            accountmanagerRepository.save(accountmanager);
        }
    }

    public void updateAccountManager(String token, Integer id, AccountManager accountmanager) {
        if (authenticateAccountManager(token).matches("OK")) {
            accountmanagerRepository.save(accountmanager);
        }
    }

    public void deleteAccountManager(String token, Integer id) {
        if (authenticateAccountManager(token).matches("OK")) {
            accountmanagerRepository.deleteById(id);
        }
    }

    public String authenticateAccountManager(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://accountmanager-authentication-service/accountmanagers/authenticate", HttpMethod.GET, entity, String.class);
        return responseEntity.getBody();
    }
}
