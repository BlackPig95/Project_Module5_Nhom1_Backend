package com.ra.project_module5_reactjs.model.dto.request;

import com.ra.project_module5_reactjs.validation.annotation.EmailExist;
import com.ra.project_module5_reactjs.validation.annotation.PasswordMatching;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@PasswordMatching(
        password = "password",
        confirmPassword = "confirmPassword"
)
public class RegisterRequest {
    @NotBlank(message = "fullName must be not blank")
    private String fullName;
    @NotBlank(message = "username must be not blank")
    private String username;
    @NotBlank(message = "phone must be not blank")
    private String phone;
    @NotBlank(message = "email must be not blank")
    @Pattern(regexp = "^[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,4}$",message = "is Valid")
    @EmailExist
    private String email;
    @NotBlank(message = "password must be not blank")
    private String password;
    @NotBlank(message = "confirmPassword must be not blank")
    private String confirmPassword;

}

