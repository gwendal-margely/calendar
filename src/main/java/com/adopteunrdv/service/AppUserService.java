package com.adopteunrdv.service;

import com.adopteunrdv.model.AppUser;
import com.adopteunrdv.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    public AppUser findByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    public AppUser save(AppUser user) {
        return appUserRepository.save(user);
    }
}
