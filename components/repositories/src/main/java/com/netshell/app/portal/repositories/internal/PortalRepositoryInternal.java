package com.netshell.app.portal.repositories.internal;

import com.netshell.app.portal.models.PortalApplicationInternal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortalRepositoryInternal extends CrudRepository<PortalApplicationInternal, String> {
}
