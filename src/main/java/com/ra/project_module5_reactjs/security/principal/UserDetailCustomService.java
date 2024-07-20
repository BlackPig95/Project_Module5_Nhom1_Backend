package com.ra.project_module5_reactjs.security.principal;

import com.ra.project_module5_reactjs.model.entity.User;

import com.ra.project_module5_reactjs.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserDetailCustomService implements UserDetailsService
{

    @Autowired
    private UserRepository userRepository ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
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
                .status(user.getStatus())
                .username(user.getUsername())
                .authorities(user.getRoles().stream().map(roles -> new SimpleGrantedAuthority(roles.getName().toString())).toList())
                .build();

    private final IUserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<User> optionalUser = userRepo.findByUsername(username);
        if (optionalUser.isPresent())
        {
            User user = optionalUser.get();
            return UserDetailCustom.builder()
                    .username(user.getUsername())
                    .build();
        }
        throw new UsernameNotFoundException("No such username exist");

    }
}
