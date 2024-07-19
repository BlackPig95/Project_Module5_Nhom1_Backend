package com.ra.project_module5_reactjs.security.principal;

import com.ra.project_module5_reactjs.model.entity.User;
import com.ra.project_module5_reactjs.repository.IUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailCustomService implements UserDetailsService
{
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
