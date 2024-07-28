package com.ra.project_module5_reactjs.controller.client;

import com.ra.project_module5_reactjs.model.dto.request.ChangePassword;
import com.ra.project_module5_reactjs.service.design.general.IForgotPasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class ChangePasswordController {

    private final IForgotPasswordService forgotPasswordService;


    @PostMapping("/changePassword")
    public ResponseEntity<String> changePasswordForLoggedInUser(@RequestBody ChangePassword changePassword) {
        try {
            forgotPasswordService.changePasswordUser(changePassword);
            return ResponseEntity.ok("Password has been changed");
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }
}