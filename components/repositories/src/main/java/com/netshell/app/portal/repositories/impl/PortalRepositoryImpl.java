package com.netshell.app.portal.repositories.impl;

import com.netshell.app.portal.models.PortalApplicationInternal;
import com.netshell.app.portal.repositories.api.PortalRepositoryApi;
import com.netshell.app.portal.repositories.internal.PortalRepositoryInternal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PortalRepositoryImpl implements PortalRepositoryApi {

    private final PortalRepositoryInternal internal;

    @Autowired
    public PortalRepositoryImpl(PortalRepositoryInternal internal) {
        this.internal = internal;
    }

    @Override
    public Optional<PortalApplicationInternal> getApplication(String applicationId) {
        return internal.findById(applicationId);
    }

    @Override
    public Iterable<PortalApplicationInternal> getAllApplications() {
        return internal.findAll();
    }

    @Override
    public PortalApplicationInternal registerApplication(PortalApplicationInternal validApp) {
        return internal.save(validApp);
    }
}
