package com.netshell.app.portal.repositories.api;

import com.netshell.app.portal.models.ApplicationUser;

import java.util.Optional;

public interface UserRepositoryApi {
    Optional<ApplicationUser> getUser(String id);

    Optional<ApplicationUser> getUserByUsername(String username);

    ApplicationUser createUser(ApplicationUser user);
}
