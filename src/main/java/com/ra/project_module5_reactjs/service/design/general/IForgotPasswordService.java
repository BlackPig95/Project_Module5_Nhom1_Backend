package com.ra.project_module5_reactjs.service.design.general;

import com.ra.project_module5_reactjs.model.dto.request.ChangePassword;

public interface IForgotPasswordService {
    void sendOtp(String email);
    void verifyOtp(Integer otp, String email);
    void changePassword(ChangePassword changePassword, String email);
    void changePasswordUser(ChangePassword changePassword);
}