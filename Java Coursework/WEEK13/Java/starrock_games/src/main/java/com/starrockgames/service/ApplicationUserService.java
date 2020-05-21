package com.starrockgames.service;

import com.starrockgames.model.ApplicationUser;

public interface ApplicationUserService {
    ApplicationUser findByUserName(String username);
}
