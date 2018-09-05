/*
 * User
 *
 * 9/4/18 7:33 PM
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

public class User {

    private String id;
    private String username;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
