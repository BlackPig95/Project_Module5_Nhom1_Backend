package com.ra.project_module5_reactjs.controller.client;

import com.ra.project_module5_reactjs.model.dto.response.ApiResponse;
import com.ra.project_module5_reactjs.model.dto.response.CustomResponseEntity;
import com.ra.project_module5_reactjs.service.implementation.admin.ReviewServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/review")
@RequiredArgsConstructor
public class ClientReviewController
{
    private final ReviewServiceImpl service;
    private final HttpStatus httpOk = HttpStatus.OK;
    //    http://localhost:8080/api/v1/banner

    @GetMapping()
    public CustomResponseEntity<?> getAllReview()
    {
        return CustomResponseEntity.builder()
                .statusCode(httpOk.value())
                .status(httpOk)
                .message("Danh sách đánh giá bình luận")
                .data(service.getAllReview())
                .build();
    }
}
