package com.ra.project_module5_reactjs.controller.admin;


import com.ra.project_module5_reactjs.model.dto.response.ApiResponse;
import com.ra.project_module5_reactjs.model.dto.response.CustomResponseEntity;
import com.ra.project_module5_reactjs.model.entity.Movie;
import com.ra.project_module5_reactjs.model.entity.Room;
import com.ra.project_module5_reactjs.service.design.admin.IRoomService;
import com.ra.project_module5_reactjs.service.implementation.admin.RoomServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin/rooms")
public class RoomController
{
    private final IRoomService roomService;
    private final HttpStatus httpOk = HttpStatus.OK;

    @GetMapping({"/", ""})
    public CustomResponseEntity<?> findAllRooms(@PageableDefault(page = 0, size = 5,
            sort = "id", direction = Sort.Direction.ASC) Pageable pageable)
    {
        Page<Room> listRoom = roomService.findAll(pageable);
        System.out.println(pageable);
        return CustomResponseEntity.builder()
                .statusCode(httpOk.value())
                .status(httpOk)
                .message("Danh sách các phòng chiếu")
                .data(listRoom)
                .build();
    }

    @PostMapping({"/", ""})
    public CustomResponseEntity<?> addRoom(@RequestBody Room room)
    {
        return CustomResponseEntity.builder()
                .statusCode(httpOk.value())
                .status(httpOk)
                .message("Thêm phòng chiếu")
                .data(roomService.addRoom(room))
                .build();
    }

    @DeleteMapping("/{roomId}")
    public CustomResponseEntity<?> deleteRoom(@PathVariable Long roomId)
    {
        roomService.deleteRoom(roomId);
        return CustomResponseEntity.builder()
                .statusCode(httpOk.value())
                .status(httpOk)
                .message("Xóa phòng chiếu")
                .data("Đã thực hiện yêu cầu xóa phòng chiếu có id " + roomId)
                .build();
    }

    @PutMapping({"/", ""})
    public CustomResponseEntity<?> editRoom(@RequestBody Room room)
    {
        return CustomResponseEntity.builder()
                .statusCode(httpOk.value())
                .status(httpOk)
                .message("Cập nhật phòng chiếu")
                .data(roomService.editRoom(room))
                .build();
    }
}
