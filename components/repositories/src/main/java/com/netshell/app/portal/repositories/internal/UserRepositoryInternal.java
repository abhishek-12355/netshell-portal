package com.netshell.app.portal.repositories.internal;

import com.netshell.app.portal.models.ApplicationUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryInternal extends CrudRepository<ApplicationUser, String> {

    Optional<ApplicationUser> findByUsername(String username);

}
