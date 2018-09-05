package com.netshell.app.portal.models;

import javax.persistence.*;
import java.net.URI;

@Entity
@Table(name = "PORTAL_APPLICATION", schema = "NS_PORTAL")
public class PortalApplicationInternal {

    private String id;
    private String name;
    private String domain;
    private URI uri;
    private URI iconUri;
    private boolean defaultApp;

    @Id
    @Column
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Basic
    @Column
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Basic
    @Column
    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    @Basic
    @Column
    public URI getIconUri() {
        return iconUri;
    }

    public void setIconUri(URI iconUri) {
        this.iconUri = iconUri;
    }

    @Basic
    @Column
    public boolean isDefaultApp() {
        return defaultApp;
    }

    public void setDefaultApp(boolean defaultApp) {
        this.defaultApp = defaultApp;
    }
}
