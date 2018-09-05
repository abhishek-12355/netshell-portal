package com.netshell.app.portal.models;

import javax.persistence.*;

@Entity
@Table(name = "APPLICATION_USER", schema = "NS_PORTAL")
public class ApplicationUser {

    private String id;
    private String username;
    private String password;

    @Id
    @Column
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
