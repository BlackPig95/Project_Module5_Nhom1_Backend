package com.ra.project_module5_reactjs.controller.admin;


import com.ra.project_module5_reactjs.model.dto.response.ApiResponse;
import com.ra.project_module5_reactjs.model.entity.Banner;
import com.ra.project_module5_reactjs.model.entity.Review;
import com.ra.project_module5_reactjs.service.implementation.admin.ReviewServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/review")
@RequiredArgsConstructor
public class ReviewController
{
    private final ReviewServiceImpl service;

    //    http://localhost:8080/api/v1/banner

    @GetMapping()
    ApiResponse<?> getAllReview()
    {
        return ApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message("")
                .result(service.getAllReview())
                .build();
    }

    //    http://localhost:8080/api/v1/banner

    @PutMapping()
    ApiResponse<?> updateReview(@RequestBody Review review)
    {
        service.updateReview(review);
        return ApiResponse.builder()
                .code(HttpStatus.NO_CONTENT.value())
                .message("updated")
                .build();
    }
}
