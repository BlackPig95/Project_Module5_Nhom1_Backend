package com.ra.project_module5_reactjs.controller.admin;


import com.ra.project_module5_reactjs.model.dto.response.ApiResponse;
import com.ra.project_module5_reactjs.service.implementation.admin.ShowTimeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/showtime")
@RequiredArgsConstructor
public class ShowTimeController {
    private final ShowTimeServiceImpl service;


    //    http://localhost:8080/api/v1/showtime?movieId=1

    @GetMapping()
    ApiResponse<?> getShowtimeByMoviesId(@RequestParam("movieId") Long movieId){
        return
                 ApiResponse.builder()
                         .code(HttpStatus.OK.value())
                         .message("OK")
                         .result(service.findShowTimeByMovieId(movieId))
                         .build();

    }

}
