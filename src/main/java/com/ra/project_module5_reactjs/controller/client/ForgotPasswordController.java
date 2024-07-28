// ForgotPasswordController.java
package com.ra.project_module5_reactjs.controller.client;

import com.ra.project_module5_reactjs.model.dto.request.ChangePassword;
import com.ra.project_module5_reactjs.service.design.general.IForgotPasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("api/v1/forgotPassword")
@RequiredArgsConstructor
public class ForgotPasswordController {
    private final IForgotPasswordService forgotPasswordService;

    @PostMapping("/verifyMail/{email}")
    public ResponseEntity<String> verifyEmail(@PathVariable String email) {
        forgotPasswordService.sendOtp(email);
        return ResponseEntity.ok("Email sent for verification");
    }

    @PostMapping("/verifyOtp/{otp}/{email}")
    public ResponseEntity<String> verifyOtp(@PathVariable Integer otp, @PathVariable String email) {
        try {
            forgotPasswordService.verifyOtp(otp, email);
            return ResponseEntity.ok("OTP verified");
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/changePassword/{email}")
    public ResponseEntity<String> changePasswordHandler(@RequestBody ChangePassword changePassword, @PathVariable String email) {
        try {
            forgotPasswordService.changePassword(changePassword, email);
            return ResponseEntity.ok("Password has been changed");
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }


}
