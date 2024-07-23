package com.ra.project_module5_reactjs.controller.admin;


import com.ra.project_module5_reactjs.model.dto.response.ApiResponse;
import com.ra.project_module5_reactjs.model.entity.Banner;
import com.ra.project_module5_reactjs.service.implementation.admin.BannerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/banner")
@RequiredArgsConstructor
public class BannerController
{

    private final BannerServiceImpl service;
    //    http://localhost:8080/api/v1/banner

    @GetMapping()
    ApiResponse<?> getAllBanner()
    {
        return ApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message("")
                .result(service.getAllBanner())
                .build();
    }

    @PostMapping()
    ApiResponse<?> createBanner(@RequestBody Banner banner)
    {
        return ApiResponse.builder()
                .code(HttpStatus.CREATED.value())
                .message("")
                .result(service.createBanner(banner))
                .build();
    }

    @PutMapping()
    ApiResponse<?> updateBanner(@RequestBody Banner banner)
    {
        service.updateBanner(banner);
        return ApiResponse.builder()
                .code(HttpStatus.NO_CONTENT.value())
                .message("updated")

                .build();
    }

    @DeleteMapping()
    ApiResponse<?> deleteBanner(@RequestBody Banner banner)
    {
        service.deleteBanner(banner);
        return ApiResponse.builder()
                .code(HttpStatus.NO_CONTENT.value())
                .message("deleted")
                .build();
    }
}
