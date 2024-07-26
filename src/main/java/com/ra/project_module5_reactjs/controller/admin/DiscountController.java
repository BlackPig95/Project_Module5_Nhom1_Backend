package com.ra.project_module5_reactjs.controller.admin;

import com.ra.project_module5_reactjs.exception.CustomException;
import com.ra.project_module5_reactjs.model.dto.request.DiscountRequest;
import com.ra.project_module5_reactjs.model.entity.Discount;
import com.ra.project_module5_reactjs.service.design.admin.IDiscountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/admin/voucher-management")
@RequiredArgsConstructor

public class DiscountController {
    private final IDiscountService discountService;

    @GetMapping
    public ResponseEntity<Page<Discount>> findAll(
            @PageableDefault(page = 0, size = 3, sort = "id", direction = Sort.Direction.ASC) Pageable pageable

    ) {
        return ResponseEntity.ok().body(discountService.findAllDiscount(pageable));
    }

    @GetMapping("/{discountId}")
    public ResponseEntity<?> findById(@PathVariable Long discountId) throws CustomException {
        return ResponseEntity.ok().body(discountService.findById(discountId));
    }

    @PostMapping
    public ResponseEntity<?> addNewDiscount( @ModelAttribute DiscountRequest discountRequest) throws ParseException {
        return ResponseEntity.created(URI.create("/api/v1/admin/voucher-management")).body(discountService.addNewDiscount(discountRequest));
    }

    @PutMapping("/{discountId}")
    public ResponseEntity<?> updateDiscount(@PathVariable Long discountId, @Valid @ModelAttribute DiscountRequest discountRequest ) throws CustomException, ParseException {
        return ResponseEntity.ok(discountService.updateDiscount(discountRequest,discountId));
    }

    @DeleteMapping("/{discountId}")
    public ResponseEntity<?> deleteDiscount (@PathVariable Long discountId) throws CustomException {
        discountService.deleteByIdDiscount(discountId);
        return ResponseEntity.ok().body("Delete successfully");
    }
}
