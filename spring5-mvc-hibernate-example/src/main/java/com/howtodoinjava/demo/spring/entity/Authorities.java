package com.howtodoinjava.demo.spring.entity;

import javax.persistence.*;

/**
 * Created by Reshan on 21/09/2018.
 */
@Entity
@Table(name = "AUTHORITIES")
public class Authorities {
    @Id
    @Column(name = "AUTHORITY")
    private String authority;

    @ManyToOne
    @JoinColumn(name = "USERNAME")
    private Users users;

    public Authorities() {
    }

    public Authorities(String authority, Users users) {
        this.authority = authority;
        this.users = users;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Authorities{" +
                "authority='" + authority + '\'' +
                ", users=" + users +
                '}';
    }
}
