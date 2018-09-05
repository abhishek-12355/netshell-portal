package com.netshell.app.portal.repositories.impl;

import com.netshell.app.portal.models.ApplicationUser;
import com.netshell.app.portal.repositories.api.UserRepositoryApi;
import com.netshell.app.portal.repositories.internal.UserRepositoryInternal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepositoryApi {

    private final UserRepositoryInternal internal;

    @Autowired
    public UserRepositoryImpl(UserRepositoryInternal internal) {
        this.internal = internal;
    }

    @Override
    public Optional<ApplicationUser> getUser(String id) {
        return internal.findById(id);
    }

    @Override
    public Optional<ApplicationUser> getUserByUsername(String username) {
        return internal.findByUsername(username);
    }

    @Override
    public ApplicationUser createUser(ApplicationUser user) {
        return internal.save(user);
    }
}
