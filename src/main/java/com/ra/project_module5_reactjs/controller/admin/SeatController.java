package com.ra.project_module5_reactjs.controller.admin;


import com.ra.project_module5_reactjs.model.dto.response.ApiResponse;
import com.ra.project_module5_reactjs.model.entity.Seat;
import com.ra.project_module5_reactjs.service.implementation.admin.SeatServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/seat")
@RequiredArgsConstructor
public class SeatController {

    private final SeatServiceImpl service;

    //    http://localhost:8080/api/v1/seat?page=10&limit=3
    @GetMapping()
    ApiResponse<?> getSeatPagination(@RequestParam("page") Integer page,
                           @RequestParam("limit") Integer limit){


        return ApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message("")
                .result(service.getSeatPagination(page - 1,limit))
                .build();
    }

    @GetMapping("/sort-asc") // http://localhost:8080/api/v1/seat/sort-asc?page=1&limit=3&sort=asc
    public ApiResponse<?> getSeatPagination(
            @RequestParam("page") Integer page,
            @RequestParam("limit") Integer limit,
            @RequestParam(value = "sort", defaultValue = "asc") String sort) {

        Page<Seat> product = service.sortByNumber(page - 1, limit, sort);

        return ApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message("")
                .result(product)
                .build();
    }

    //    http://localhost:8080/api/v1/seat/getAll

    @GetMapping("/getAll")
    ApiResponse<?> getAllSeat(){
        return ApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message("")
                .result(service.getAllSeat())
                .build();
    }
}
