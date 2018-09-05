package com.netshell.app.portal.impl;

import com.netshell.app.portal.api.UserApi;
import com.netshell.app.portal.mapper.RequestMapper;
import com.netshell.app.portal.models.User;
import com.netshell.app.portal.services.api.UserService;
import com.netshell.libraries.utilities.strategy.StrategyProvider;
import com.netshell.libraries.utilities.validation.ValidationException;
import com.netshell.libraries.utilities.validation.ValidationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserApiImpl implements UserApi {

    private final UserService userService;
    private final RequestMapper mapper;

    @Autowired
    public UserApiImpl(UserService userService, RequestMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<Void> signUp(@RequestBody User user) throws ValidationException {
        @SuppressWarnings("unchecked") final User validUser = (User) StrategyProvider
                .find(ValidationStrategy.class, User.class.getName())
                .validate(user);

        final String id = userService.createUser(mapper.fromUser(validUser));
        final URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/user/{id}")
                .build(id);
        return ResponseEntity.created(location).build();
    }
}
