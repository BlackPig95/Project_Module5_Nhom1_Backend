package com.ra.project_module5_reactjs.security.principal;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDetailCustom implements UserDetails
{
    private String username;
    private String authorizationType = "Bearer ";
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return this.authorities;
    }

    @Override
    public String getPassword()
    {
        return "";
    }

    @Override
    public String getUsername()
    {
        return "";
    }
}
