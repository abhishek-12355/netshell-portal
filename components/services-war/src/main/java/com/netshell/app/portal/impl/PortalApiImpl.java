package com.netshell.app.portal.impl;

import com.netshell.app.portal.api.PortalApi;
import com.netshell.app.portal.mapper.RequestMapper;
import com.netshell.app.portal.models.PortalApplication;
import com.netshell.app.portal.models.PortalApplicationInternal;
import com.netshell.app.portal.services.api.PortalService;
import com.netshell.libraries.utilities.strategy.StrategyProvider;
import com.netshell.libraries.utilities.validation.ValidationException;
import com.netshell.libraries.utilities.validation.ValidationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
public class PortalApiImpl implements PortalApi {

    private final PortalService portalService;
    private final RequestMapper mapper;

    @Autowired
    public PortalApiImpl(PortalService portalService, RequestMapper mapper) {
        this.portalService = portalService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<Void> registerApplication(@Valid @RequestBody PortalApplication application) throws URISyntaxException, ValidationException {

        @SuppressWarnings("unchecked") final PortalApplication validApp = (PortalApplication) StrategyProvider
                .find(ValidationStrategy.class, PortalApplication.class.getName())
                .validate(application);

        final String id = portalService.registerApplication(mapper.fromPortalApplication(validApp));
        final URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/application/{id}")
                .build(id);
        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<PortalApplication> getApplication(@NotNull @PathVariable("id") String applicationId) {
        Optional<PortalApplicationInternal> application = portalService.getApplication(applicationId);
        return application.isPresent()
                ? ResponseEntity.ok(mapper.toPortalApplication(application.get()))
                : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<List<PortalApplication>> getAllApplication() {
        return ResponseEntity.ok(mapper.mapCollection(
                portalService.getAllApplications(),
                mapper::toPortalApplication
        ));
    }
}
