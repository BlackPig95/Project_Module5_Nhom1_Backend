package com.ra.project_module5_reactjs.service.implementation.admin;

import com.ra.project_module5_reactjs.constant.RoleEnum;
import com.ra.project_module5_reactjs.exception.CustomException;
import com.ra.project_module5_reactjs.model.dto.request.LoginRequest;
import com.ra.project_module5_reactjs.model.dto.request.RegisterRequest;
import com.ra.project_module5_reactjs.model.dto.request.UserEditRequest;
import com.ra.project_module5_reactjs.model.dto.response.JwtResponse;
import com.ra.project_module5_reactjs.model.entity.Role;
import com.ra.project_module5_reactjs.model.entity.User;
import com.ra.project_module5_reactjs.repository.IUserRepository;
import com.ra.project_module5_reactjs.security.jwt.JwtProvider;
import com.ra.project_module5_reactjs.security.principal.UserDetailCustom;
import com.ra.project_module5_reactjs.service.design.admin.IRoleService;
import com.ra.project_module5_reactjs.service.design.admin.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final JwtProvider jwtProvider;
    private final AuthenticationManager manager;
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final IRoleService roleService;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
                .username(UserDetailCustom.getUsername())
                .phone(UserDetailCustom.getPhone())
                .address(UserDetailCustom.getAddress())
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

    @Override
    public Page<User> findAll(Pageable pageable, String search) {
        Page<User> users;
        if(search.isEmpty()) {
            users = userRepository.findAll(pageable);
        }else {
            users = userRepository.findAllByUsernameContains(search,pageable);
        }
        return users;
    }

    @Override
    public void updateUserStatus(Long id) throws CustomException {
        User user = userRepository.findById(id).orElseThrow(() -> new CustomException("User not found",HttpStatus.NOT_FOUND));
        user.setStatus(!user.getStatus()); 
        userRepository.save(user);

    }

    @Override
    public void updateUser(UserEditRequest userEditRequest) throws CustomException, ParseException {
        // Lấy thông tin người dùng từ token
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Tìm người dùng theo username
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new CustomException("Email not found", HttpStatus.NOT_FOUND));

        // Cập nhật thông tin người dùng
        user.setFullName(userEditRequest.getFullName());
        user.setPhone(userEditRequest.getPhone());
        user.setAddress(userEditRequest.getAddress());

        // Lưu thông tin người dùng đã cập nhật
        userRepository.save(user);

    }



}
