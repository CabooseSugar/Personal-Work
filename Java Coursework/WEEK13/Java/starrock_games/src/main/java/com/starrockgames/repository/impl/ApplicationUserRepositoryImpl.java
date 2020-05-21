package com.starrockgames.repository.impl;

import com.google.common.collect.MoreCollectors;
import com.starrockgames.model.ApplicationUser;
import com.starrockgames.repository.ApplicationUserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ApplicationUserRepositoryImpl implements ApplicationUserRepository {

    //
    //  Instance data
    List<ApplicationUser> userList = new ArrayList<>();

    @Override
    public ApplicationUser findByUserName(String userName) {

        //
        //  Old school
//        for (ApplicationUser user : userList) {
//            if (user.getUsername().equalsIgnoreCase(userName)) {
//                return user;
//            }
//        }

//        return null;

//        //
//        //  JAVA 8
//        List<ApplicationUser> filtered = userList.stream()
//                .filter(u -> u.getUsername().equalsIgnoreCase(userName))
//                .collect(Collectors.toList());
//        return (filtered != null && filtered.size() >0) ? filtered.get(0) : null;

        //
        //  JAVA 8 with Guava
        return userList.stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(userName))
                .collect(MoreCollectors.onlyElement());

    }

    @Override
    public ApplicationUser addUser(ApplicationUser applicationUser) {
        userList.add(applicationUser);
        return applicationUser;
    }
}
