package com.netshell.app.portal.services.impl;

import com.netshell.app.portal.models.PortalApplicationInternal;
import com.netshell.app.portal.repositories.api.PortalRepositoryApi;
import com.netshell.app.portal.services.api.PortalService;
import com.netshell.libraries.utilities.common.CommonMethods;
import com.netshell.libraries.utilities.services.id.IDGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PortalServiceImpl implements PortalService {

    private final PortalRepositoryApi repository;

    @Autowired
    public PortalServiceImpl(PortalRepositoryApi repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<PortalApplicationInternal> getAllApplications() {
        return repository.getAllApplications();
    }

    @Override
    public Optional<PortalApplicationInternal> getApplication(String applicationId) {
        return repository.getApplication(applicationId);
    }

    @Override
    public String registerApplication(PortalApplicationInternal application) {
        if (CommonMethods.isEmpty(application.getId())) {
            application.setId(IDGeneratorService.create(PortalApplicationInternal.class.getSimpleName()));
        }

        repository.registerApplication(application);
        return application.getId();
    }
}
