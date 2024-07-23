package com.ra.project_module5_reactjs.service.design.admin;

import com.ra.project_module5_reactjs.exception.CustomException;
import com.ra.project_module5_reactjs.model.dto.request.TicketPriceRequest;
import com.ra.project_module5_reactjs.model.entity.TicketPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;

public interface ITicketPriceService {
    Page<TicketPrice> findAllTicketPrices(Pageable pageable);
    TicketPrice findById(Long findId) throws CustomException;
    TicketPrice addNewTicketPrice(TicketPriceRequest ticketPriceRequest) throws ParseException;
    TicketPrice updateTicketPrice(TicketPriceRequest ticketPriceRequest, Long updateId) throws CustomException, ParseException;
    void deleteByIdTicketPrice(Long deleteId) throws CustomException;
}