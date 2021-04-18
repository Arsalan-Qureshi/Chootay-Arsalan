package com.chootay.adminservice;

import com.chootay.adminservice.models.Admin;
import com.chootay.adminservice.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/admins")
    public Iterable<Admin> getAllAdmins(@RequestHeader("Authorization") String token) {
        return adminService.getAllAdmins(token);
    }

//    @RequestMapping("/admins")
//    public List<Admin> getAllAdmins() {
//        return adminService.getAll();
//    }

//    @RequestMapping("/buyers/search/{userName}")
//    public Optional<Admin> getAdminByUsername(@RequestHeader("Authorization") String token, @PathVariable("userName") String userName) {
//        return adminService.getAdminByUsername(token, userName);
//    }

    @RequestMapping("/admins/{id}")
    public Optional<Admin> getAdmin(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id) {
        return adminService.getAdmin(token, id);
    }

    @PostMapping("/admins")
    public void addAdmin(@RequestHeader("Authorization") String token, @RequestBody Admin admin) {
        adminService.addAdmin(token, admin);
    }

    @PutMapping("/admins/{id}")
    public void updateAdmin(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id, @RequestBody Admin admin) {
        adminService.updateAdmin(token, id, admin);
    }

    @DeleteMapping("/admins/{id}")
    public void deleteAdmin(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id) {
        adminService.deleteAdmin(token, id);
    }
}
