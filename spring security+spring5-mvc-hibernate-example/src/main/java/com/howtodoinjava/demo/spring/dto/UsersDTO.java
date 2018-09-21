package com.howtodoinjava.demo.spring.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Reshan on 21/09/2018.
 */
public class UsersDTO {

    private String userName;
    private String Password;
    private boolean enabled;
    private List<AuthoritiesDTO>authoritiesDTOS=new ArrayList<>();

    public UsersDTO() {
    }

    public UsersDTO(String userName, String password, boolean enabled, List<AuthoritiesDTO> authoritiesDTOS) {
        this.userName = userName;
        Password = password;
        this.enabled = enabled;
        this.authoritiesDTOS = authoritiesDTOS;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<AuthoritiesDTO> getAuthoritiesDTOS() {
        return authoritiesDTOS;
    }

    public void setAuthoritiesDTOS(List<AuthoritiesDTO> authoritiesDTOS) {
        this.authoritiesDTOS = authoritiesDTOS;
    }

    @Override
    public String toString() {
        return "UsersDTO{" +
                "userName='" + userName + '\'' +
                ", Password='" + Password + '\'' +
                ", enabled=" + enabled +
                ", authoritiesDTOS=" + authoritiesDTOS +
                '}';
    }
}
