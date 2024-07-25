package com.ra.project_module5_reactjs.service.design.admin;


import com.ra.project_module5_reactjs.exception.CustomException;
import com.ra.project_module5_reactjs.model.dto.request.LoginRequest;
import com.ra.project_module5_reactjs.model.dto.request.RegisterRequest;
import com.ra.project_module5_reactjs.model.dto.request.UserEditRequest;
import com.ra.project_module5_reactjs.model.dto.response.JwtResponse;
import com.ra.project_module5_reactjs.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;

public interface IUserService {
    JwtResponse login(LoginRequest loginRequest) throws CustomException;
    void register(RegisterRequest registerRequest) throws CustomException;
    Page<User> findAll(Pageable pageable,String search);
    void updateUserStatus(Long id) throws CustomException;
    void updateUser( UserEditRequest userEditRequest) throws CustomException, ParseException;

}
