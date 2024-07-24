package com.ra.project_module5_reactjs.controller.admin;


import com.ra.project_module5_reactjs.exception.CustomException;
import com.ra.project_module5_reactjs.model.dto.request.TicketPriceRequest;
import com.ra.project_module5_reactjs.model.entity.TicketPrice;
import com.ra.project_module5_reactjs.service.design.admin.ITicketPriceService;
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
@RequestMapping("/api/v1/admin/ticket-price-management")
@RequiredArgsConstructor
public class TicketPriceController {
    private final ITicketPriceService ticketPriceService;

    @GetMapping
    public ResponseEntity<Page<TicketPrice>> findAll(
            @PageableDefault(page = 0, size = 3, sort = "id", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return ResponseEntity.ok().body(ticketPriceService.findAllTicketPrices(pageable));
    }

    @GetMapping("/{ticketPriceId}")
    public ResponseEntity<?> findById(@PathVariable Long ticketPriceId) throws CustomException {
        return ResponseEntity.ok().body(ticketPriceService.findById(ticketPriceId));
    }

    @PostMapping
    public ResponseEntity<?> addNewTicketPrice(@RequestBody TicketPriceRequest ticketPriceRequest) throws ParseException {
        return ResponseEntity.created(URI.create("/api/v1/admin/ticket-price-management")).body(ticketPriceService.addNewTicketPrice(ticketPriceRequest));
    }

    @PutMapping("/{ticketPriceId}")
    public ResponseEntity<?> updateTicketPrice(@PathVariable Long ticketPriceId, @Valid @RequestBody TicketPriceRequest ticketPriceRequest) throws CustomException, ParseException {
        return ResponseEntity.ok(ticketPriceService.updateTicketPrice(ticketPriceRequest, ticketPriceId));
    }

    @DeleteMapping("/{ticketPriceId}")
    public ResponseEntity<?> deleteTicketPrice(@PathVariable Long ticketPriceId) throws CustomException {
        ticketPriceService.deleteByIdTicketPrice(ticketPriceId);
        return ResponseEntity.ok().body("Delete successfully");
    }
}