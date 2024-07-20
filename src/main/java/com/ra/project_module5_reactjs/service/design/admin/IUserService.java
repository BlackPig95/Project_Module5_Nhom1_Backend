package com.ra.project_module5_reactjs.service.design.admin;


import com.ra.project_module5_reactjs.exception.CustomException;
import com.ra.project_module5_reactjs.model.dto.request.LoginRequest;
import com.ra.project_module5_reactjs.model.dto.request.RegisterRequest;
import com.ra.project_module5_reactjs.model.dto.response.JwtResponse;

public interface IUserService {
    JwtResponse login(LoginRequest loginRequest) throws CustomException;
    void register(RegisterRequest registerRequest) throws CustomException;
}
