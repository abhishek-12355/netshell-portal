package com.netshell.app.portal.services.api;

import com.netshell.app.portal.models.PortalApplicationInternal;

import java.util.Optional;

public interface PortalService {
    Iterable<PortalApplicationInternal> getAllApplications();

    Optional<PortalApplicationInternal> getApplication(String applicationId);

    String registerApplication(PortalApplicationInternal fromPortalApplication);
}
