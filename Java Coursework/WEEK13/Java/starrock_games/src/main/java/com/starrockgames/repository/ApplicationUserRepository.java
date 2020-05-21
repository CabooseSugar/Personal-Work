package com.starrockgames.repository;

import com.starrockgames.model.ApplicationUser;

public interface ApplicationUserRepository {
    ApplicationUser findByUserName(String userName);

    ApplicationUser addUser(ApplicationUser applicationUser);
}
