package com.netshell.app.portal.api;

import com.netshell.app.portal.models.User;
import com.netshell.libraries.utilities.validation.ValidationException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface UserApi {

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> signUp(@RequestBody User user) throws ValidationException;

}
