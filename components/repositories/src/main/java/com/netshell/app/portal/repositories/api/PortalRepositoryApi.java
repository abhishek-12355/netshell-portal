package com.netshell.app.portal.repositories.api;

import com.netshell.app.portal.models.PortalApplicationInternal;

import java.util.Optional;

public interface PortalRepositoryApi {
    Optional<PortalApplicationInternal> getApplication(String applicationId);

    Iterable<PortalApplicationInternal> getAllApplications();

    PortalApplicationInternal registerApplication(PortalApplicationInternal validApp);
}
