package com.netshell.app.portal.mapper;

import com.netshell.app.portal.models.ApplicationUser;
import com.netshell.app.portal.models.PortalApplication;
import com.netshell.app.portal.models.PortalApplicationInternal;
import com.netshell.app.portal.models.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Mapper(componentModel = "spring")
public interface RequestMapper {

    PortalApplicationInternal fromPortalApplication(PortalApplication application) throws URISyntaxException;

    @InheritInverseConfiguration
    PortalApplication toPortalApplication(PortalApplicationInternal applicationInternal);

    ApplicationUser fromUser(User user);

    @InheritInverseConfiguration
    User toUser(ApplicationUser applicationUser);

    default String fromURI(URI uri) {
        return String.valueOf(uri);
    }

    default URI toURI(String uri) throws URISyntaxException {
        return uri == null ? null : new URI(uri);
    }

    default <T, R> List<R> mapCollection(Iterable<? extends T> iterable, Function<T, R> mapperFunction) {
        return StreamSupport.stream(iterable.spliterator(), true)
                .map(mapperFunction).collect(Collectors.toList());
    }

}
