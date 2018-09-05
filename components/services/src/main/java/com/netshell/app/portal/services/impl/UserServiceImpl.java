package com.netshell.app.portal.services.impl;

import com.netshell.app.portal.models.ApplicationUser;
import com.netshell.app.portal.models.PortalApplicationInternal;
import com.netshell.app.portal.repositories.api.UserRepositoryApi;
import com.netshell.app.portal.services.api.UserService;
import com.netshell.libraries.utilities.common.CommonMethods;
import com.netshell.libraries.utilities.services.id.IDGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepositoryApi userRepository;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepositoryApi userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public String createUser(ApplicationUser user) {
        if (CommonMethods.isEmpty(user.getId())) {
            user.setId(IDGeneratorService.create(PortalApplicationInternal.class.getSimpleName()));
        }

        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.createUser(user);
        return user.getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ApplicationUser> applicationUser = userRepository.getUserByUsername(username);
        if (!applicationUser.isPresent()) {
            throw new UsernameNotFoundException(username);
        }

        return new User(applicationUser.get().getUsername(), applicationUser.get().getPassword(), Collections.emptyList());
    }
}
