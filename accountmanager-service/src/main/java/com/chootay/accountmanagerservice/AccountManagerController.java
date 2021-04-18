package com.chootay.accountmanagerservice;

import com.chootay.accountmanagerservice.models.AccountManager;
import com.chootay.accountmanagerservice.services.AccountManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AccountManagerController {
    @Autowired
    private AccountManagerService accountmanagerService;

    @RequestMapping("/accountmanagers")
    public Iterable<AccountManager> getAllAccountManagers(@RequestHeader("Authorization") String token) {
        return accountmanagerService.getAllAccountManagers(token);
    }

//    @RequestMapping("/accountmanagers")
//    public List<AccountManager> getAllAccountManagers() {
//        return accountmanagerService.getAll();
//    }

//    @RequestMapping("/buyers/search/{userName}")
//    public Optional<AccountManager> getAccountManagerByUsername(@RequestHeader("Authorization") String token, @PathVariable("userName") String userName) {
//        return accountmanagerService.getAccountManagerByUsername(token, userName);
//    }

    @RequestMapping("/accountmanagers/{id}")
    public Optional<AccountManager> getAccountManager(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id) {
        return accountmanagerService.getAccountManager(token, id);
    }

    @PostMapping("/accountmanagers")
    public void addAccountManager(@RequestHeader("Authorization") String token, @RequestBody AccountManager accountmanager) {
        accountmanagerService.addAccountManager(token, accountmanager);
    }

    @PutMapping("/accountmanagers/{id}")
    public void updateAccountManager(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id, @RequestBody AccountManager accountmanager) {
        accountmanagerService.updateAccountManager(token, id, accountmanager);
    }

    @DeleteMapping("/accountmanagers/{id}")
    public void deleteAccountManager(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id) {
        accountmanagerService.deleteAccountManager(token, id);
    }
}
