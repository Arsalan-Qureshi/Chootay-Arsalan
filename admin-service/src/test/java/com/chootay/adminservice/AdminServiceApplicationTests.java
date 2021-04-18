package com.chootay.adminservice;

import com.chootay.adminservice.models.Admin;
import com.chootay.adminservice.models.AdminRepository;
import com.chootay.adminservice.services.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceApplicationTests {

    @Autowired
    private AdminService service;

    @MockBean
    private AdminRepository repository;

    @Test
    public void addAdminTest() {
        Admin admin = new Admin(1, "chootachootay", "chotu@gmail.com", "pass", false);
        service.addAdmin("TOKEN_GOES_HERE", admin);
        verify(repository, times(1)).save(admin);
    }

    @Test
    public void deleteAdminTest() {
        Admin admin = new Admin(1, "chootachootay", "chotu@gmail.com", "pass", false);
        service.deleteAdmin("TOKEN_GOES_HERE", admin.getId());
        verify(repository, times(1)).deleteById(admin.getId());
    }
}