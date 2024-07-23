package com.ra.project_module5_reactjs.controller.client;


import com.ra.project_module5_reactjs.model.dto.response.ApiResponse;
import com.ra.project_module5_reactjs.service.implementation.client.SeatClientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/client/seat")
@RequiredArgsConstructor
public class SeatClientController {

    private final SeatClientServiceImpl seatClientService;

//    http://localhost:8080/api/v1/client/seat?roomId=1
    @GetMapping
    ApiResponse<?> getSeatByRoomId(@RequestParam("roomId") Long roomId){

        return ApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message("")
                .result(seatClientService.findSeatByRoomId(roomId))

                .build();
    }
}
