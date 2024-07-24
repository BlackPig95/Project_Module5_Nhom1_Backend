package com.ra.project_module5_reactjs.controller.client;

import com.ra.project_module5_reactjs.exception.CustomException;
import com.ra.project_module5_reactjs.model.dto.request.UserEditRequest;
import com.ra.project_module5_reactjs.service.design.admin.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserDetailController {
    private final IUserService userService;
    @PutMapping("/user-detail")
    public ResponseEntity<Void> updateUser(@RequestBody UserEditRequest userEditRequest)
            throws CustomException, ParseException {
        userService.updateUser(userEditRequest);
        return ResponseEntity.ok().build();
    }
}
