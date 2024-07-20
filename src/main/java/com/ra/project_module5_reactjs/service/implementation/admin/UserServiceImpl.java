package com.ra.project_module5_reactjs.service.implementation.admin;

import com.ra.project_module5_reactjs.constant.RoleEnum;
import com.ra.project_module5_reactjs.exception.CustomException;
import com.ra.project_module5_reactjs.model.dto.request.LoginRequest;
import com.ra.project_module5_reactjs.model.dto.request.RegisterRequest;
import com.ra.project_module5_reactjs.model.dto.response.JwtResponse;
import com.ra.project_module5_reactjs.model.entity.Role;
import com.ra.project_module5_reactjs.model.entity.User;
import com.ra.project_module5_reactjs.repository.UserRepository;
import com.ra.project_module5_reactjs.security.jwt.JwtProvider;
import com.ra.project_module5_reactjs.security.principal.UserDetailCustom;
import com.ra.project_module5_reactjs.service.design.admin.IRoleService;
import com.ra.project_module5_reactjs.service.design.admin.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final JwtProvider jwtProvider;
    private final AuthenticationManager manager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final IRoleService roleService;
    @Override
    public JwtResponse login(LoginRequest loginRequest) throws CustomException {
        Authentication authentication;
        try {
            authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        } catch (AuthenticationException e) {
            throw new CustomException("Sai tài khoản mật khẩu rồi", HttpStatus.BAD_REQUEST);
        }
        UserDetailCustom UserDetailCustom = (UserDetailCustom) authentication.getPrincipal();
        if (!UserDetailCustom.getStatus()) {
            throw new CustomException("User is blocked", HttpStatus.BAD_REQUEST);
        }
        return JwtResponse.builder()
                .accessToken(jwtProvider.createToken(UserDetailCustom))
                .fullName(UserDetailCustom.getFullName())
                .email(UserDetailCustom.getEmail())
                .status(UserDetailCustom.getStatus())
                .roles(UserDetailCustom.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet()))
                .build();
    }

    @Override
    public void register(RegisterRequest registerRequest) throws CustomException {


        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByRoleName(RoleEnum.USER));

        User user = User.builder()
                .fullName(registerRequest.getFullName())
                .username(registerRequest.getUsername())
                .phone(registerRequest.getPhone())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .roles(roles)
                .status(true)
                .build();

        userRepository.save(user);
    }



}
