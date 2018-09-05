package com.netshell.app.portal.api;

import com.netshell.app.portal.models.PortalApplication;
import com.netshell.libraries.utilities.validation.ValidationException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URISyntaxException;
import java.util.List;

public interface PortalApi {

    @RequestMapping(value = "/application", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> registerApplication(@Valid @RequestBody PortalApplication application) throws URISyntaxException, ValidationException;

    @RequestMapping(value = "/application/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PortalApplication> getApplication(@NotNull @PathVariable("id") String applicationId);

    @RequestMapping(value = "/application", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<PortalApplication>> getAllApplication();

}
