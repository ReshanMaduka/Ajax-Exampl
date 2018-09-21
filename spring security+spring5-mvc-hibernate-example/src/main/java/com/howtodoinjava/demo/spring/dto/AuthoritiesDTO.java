package com.howtodoinjava.demo.spring.dto;

/**
 * Created by Reshan on 21/09/2018.
 */
public class AuthoritiesDTO {

    private String authority;
    private UsersDTO usersDTO;

    public AuthoritiesDTO() {
    }

    public AuthoritiesDTO(String authority, UsersDTO usersDTO) {
        this.authority = authority;
        this.usersDTO = usersDTO;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public UsersDTO getUsersDTO() {
        return usersDTO;
    }

    public void setUsersDTO(UsersDTO usersDTO) {
        this.usersDTO = usersDTO;
    }

    @Override
    public String toString() {
        return "AuthoritiesDTO{" +
                "authority='" + authority + '\'' +
                ", usersDTO=" + usersDTO +
                '}';
    }
}
