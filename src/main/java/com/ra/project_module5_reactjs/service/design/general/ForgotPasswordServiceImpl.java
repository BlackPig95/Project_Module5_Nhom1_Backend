package com.ra.project_module5_reactjs.service.design.general;


import com.ra.project_module5_reactjs.model.dto.request.ChangePassword;
import com.ra.project_module5_reactjs.model.dto.response.MailBody;
import com.ra.project_module5_reactjs.model.entity.ForgotPassword;
import com.ra.project_module5_reactjs.model.entity.User;
import com.ra.project_module5_reactjs.repository.IForgotPasswordRepository;
import com.ra.project_module5_reactjs.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ForgotPasswordServiceImpl implements IForgotPasswordService {
    private final IUserRepository userRepository;
    private final EmailService emailService;
    private final IForgotPasswordRepository forgotPasswordRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void sendOtp(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Please provide a valid email"));

        int otp = otpGenerator();
        MailBody mailBody = MailBody.builder()
                .to(email)
                .text("This is the OTP for your Forgot Password request " + otp)
                .subject("OTP for Forgot password request")
                .build();
        ForgotPassword fp = ForgotPassword.builder()
                .otp(otp)
                .expirationTime(new Date(System.currentTimeMillis() + 70 * 1000))
                .user(user)
                .build();
        emailService.sendSimpleMessage(mailBody);
        forgotPasswordRepository.save(fp);
    }


    @Override
    public void verifyOtp(Integer otp, String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Please provide a valid email"));
        ForgotPassword fp = forgotPasswordRepository.findByOtpAndUser(otp, user).orElseThrow(() -> new RuntimeException("Invalid OTP for email: " + email));
        if (fp.getExpirationTime().before(Date.from(Instant.now()))) {
            forgotPasswordRepository.deleteById(fp.getFpid());
            throw new RuntimeException("OTP has expired");
        }
    }

    @Override
    public void changePassword(ChangePassword changePassword, String email) {
        if (!Objects.equals(changePassword.password(), changePassword.repeatPassword())) {
            throw new RuntimeException("Please enter the password again!");
        }
        String encodePassword = passwordEncoder.encode(changePassword.password());
        userRepository.updatePassword(email, encodePassword);
    }

    private Integer otpGenerator() {
        Random random = new Random();
        return random.nextInt(100_000, 999_999);
    }
}
