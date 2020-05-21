package com.starrockgames.service.impl;

import com.starrockgames.model.ApplicationUser;
import com.starrockgames.repository.ApplicationUserRepository;
import com.starrockgames.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {


    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Override
    public ApplicationUser findByUserName(String username) {
        return applicationUserRepository.findByUserName(username);
    }
}
