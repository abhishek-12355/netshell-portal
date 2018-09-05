/*
 * PortalApplication
 *
 * 8/27/18 1:26 PM
 *
 * Copyright (c) 1996 to 20018 Amdocs Software Systems Limited.
 * All rights reserved.
 *
 * These coded instructions, statements, and computer programs contain
 * unpublished trade secrets and proprietary information of Amdocs
 * Software Systems Limited and are protected by Federal copyright law
 * and trade secret law.  They may not be disclosed to third parties or
 * used or copied or duplicated in any form, in whole or in part, without
 * the prior written consent of Amdocs Software Systems Limited.
 */

package com.netshell.app.portal.models;

import org.springframework.lang.NonNull;

public class PortalApplication {
    private String id;
    private String name;
    private String domain;
    private String uri;
    private String iconUri;
    private boolean defaultApp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @NonNull
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getIconUri() {
        return iconUri;
    }

    public void setIconUri(String iconUri) {
        this.iconUri = iconUri;
    }

    public boolean isDefaultApp() {
        return defaultApp;
    }

    public void setDefaultApp(boolean defaultApp) {
        this.defaultApp = defaultApp;
    }
}
