package com.ra.project_module5_reactjs.security.principal;

import com.ra.project_module5_reactjs.model.entity.User;

import com.ra.project_module5_reactjs.repository.IUserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserDetailCustomService implements UserDetailsService
{

    @Autowired

    private IUserRepository IUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = IUserRepository.findByEmail(username)

                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return UserDetailCustom.builder()
                .id(user.getId())
                .avatarUrl(user.getAvatarUrl())
//                .birthDate(user.getBirthDate().toString())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .loyaltyPoints(user.getLoyaltyPoints())
                .password(user.getPassword())
                .phone(user.getPhone())
                .address(user.getAddress())
                .status(user.getStatus())
                .username(user.getUsername())
                .authorities(user.getRoles().stream().map(roles -> new SimpleGrantedAuthority(roles.getName().toString())).toList())
                .build();

    }
}
