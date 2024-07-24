package com.ra.project_module5_reactjs.controller.client;

import com.ra.project_module5_reactjs.model.dto.response.CustomResponseEntity;
import com.ra.project_module5_reactjs.service.design.client.IPaymentService;
import com.ra.project_module5_reactjs.service.design.general.IBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class ClientPaymentController
{
    private final HttpStatus httpOk = HttpStatus.OK;
    private final IPaymentService paymentService;

    @GetMapping({"/", ""})
    public CustomResponseEntity<?> findBookingHistory(@RequestParam("bookingId") String bookingId)
    {
        return CustomResponseEntity.builder()
                .statusCode(httpOk.value())
                .status(httpOk)
                .message("Danh sách lịch sử thanh toán")
                .data(paymentService.findPaymentHistoryByBookingId(Long.parseLong(bookingId)))
                .build();
    }
}
