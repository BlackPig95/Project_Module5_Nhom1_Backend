package com.ra.project_module5_reactjs.controller.client;

import com.ra.project_module5_reactjs.model.dto.response.ApiResponse;
import com.ra.project_module5_reactjs.model.dto.response.CustomResponseEntity;
import com.ra.project_module5_reactjs.service.implementation.admin.BannerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/banner")
@RequiredArgsConstructor
public class ClientBannerController
{
    private final BannerServiceImpl service;
    private final HttpStatus httpOk = HttpStatus.OK;
    //    http://localhost:8080/api/v1/banner

    @GetMapping({"/", ""})
    public CustomResponseEntity<?> getActiveBanner()
    {
        return CustomResponseEntity.builder()
                .statusCode(httpOk.value())
                .status(httpOk)
                .message("Danh sách tiêu điểm hiện tại")
                .data(service.getActiveBanner())
                .build();
    }
}
