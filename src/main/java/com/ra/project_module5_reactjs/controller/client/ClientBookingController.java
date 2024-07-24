package com.ra.project_module5_reactjs.controller.client;

import com.ra.project_module5_reactjs.model.dto.response.CustomResponseEntity;
import com.ra.project_module5_reactjs.service.design.general.IBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/booking")
@RequiredArgsConstructor
public class ClientBookingController
{
    private final HttpStatus httpOk = HttpStatus.OK;
    private final IBookingService bookingService;

    @GetMapping({"/", ""})
    public CustomResponseEntity<?> findBookingHistory(@RequestParam("userId") String userId)
    {
        return CustomResponseEntity.builder()
                .statusCode(httpOk.value())
                .status(httpOk)
                .message("Danh sách lịch sử đặt vé")
                .data(bookingService.findBookingsByUserId(Long.parseLong(userId)))
                .build();
    }
}
