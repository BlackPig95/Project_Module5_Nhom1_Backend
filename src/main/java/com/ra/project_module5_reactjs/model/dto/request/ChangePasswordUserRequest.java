package com.ra.project_module5_reactjs.model.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChangePasswordUserRequest {
    private String currentPassword;
    private String newPassword;
    private String confirmationPassword;
}
