package com.ra.project_module5_reactjs.controller.admin;


import com.ra.project_module5_reactjs.model.dto.response.ApiResponse;
import com.ra.project_module5_reactjs.model.entity.Room;
import com.ra.project_module5_reactjs.service.implementation.admin.RoomServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomServiceImpl roomService;

//    http://localhost:8080/api/v1/room?page=10&limit=3
    @GetMapping()
    ApiResponse<?> getRoom( @RequestParam("page") Integer page,
                               @RequestParam("limit") Integer limit){


        return ApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message("")
                .result(roomService.getAllProduct(page - 1,limit))
                .build();
    }

    @PostMapping()
    ApiResponse<?> createRoom(@RequestBody Room room){


        return ApiResponse.builder()
                .code(HttpStatus.CREATED.value())
                .message("CREATED")
                .result(roomService.createRoom(room))
                .build();
    }

    @PutMapping()
    ApiResponse<?> updateRoom(@RequestBody Room room){

        return ApiResponse.builder()
                .code(HttpStatus.NO_CONTENT.value())
                .build();
    }




}
