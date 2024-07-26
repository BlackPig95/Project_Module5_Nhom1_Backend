package com.ra.project_module5_reactjs.controller.general;

import com.ra.project_module5_reactjs.exception.CustomException;
import com.ra.project_module5_reactjs.model.dto.response.CustomResponseEntity;
import com.ra.project_module5_reactjs.model.entity.Discount;
import com.ra.project_module5_reactjs.service.design.admin.IDiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/discount")
@RequiredArgsConstructor
public class DiscountUserController {
    private final IDiscountService discountService;

    @GetMapping({"/", ""})
    public CustomResponseEntity<?> getAllDiscounts(
            @PageableDefault(page = 0, size = 8, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return CustomResponseEntity.builder()
                .statusCode(HttpStatus.OK.value())
                .status(HttpStatus.OK)
                .message("Danh sách khuyến mãi")
                .data(discountService.findAllDiscount(pageable))
                .build();
    }
    @GetMapping("/{discountId}")
    public CustomResponseEntity<?> findById (@PathVariable Long discountId) throws CustomException {
        return CustomResponseEntity.builder()
                .statusCode(HttpStatus.OK.value())
                .status(HttpStatus.OK)
                .message("Mã giảm giá đã được tìm thấy")
                .data(discountService.findById(discountId))
                .build();
    }
}
