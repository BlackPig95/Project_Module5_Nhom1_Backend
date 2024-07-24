package com.ra.project_module5_reactjs.service.implementation.admin;

import com.ra.project_module5_reactjs.exception.CustomException;
import com.ra.project_module5_reactjs.model.dto.request.TicketPriceRequest;
import com.ra.project_module5_reactjs.model.entity.TicketPrice;
import com.ra.project_module5_reactjs.repository.ITicketPriceRepository;
import com.ra.project_module5_reactjs.service.design.admin.ITicketPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketPriceServiceImpl implements ITicketPriceService {
    private final ITicketPriceRepository ticketPriceRepository;

    @Override
    public Page<TicketPrice> findAllTicketPrices(Pageable pageable) {
        return ticketPriceRepository.findAll(pageable);
    }

    @Override
    public TicketPrice findById(Long findId) throws CustomException {
        return ticketPriceRepository.findById(findId)
                .orElseThrow(() -> new CustomException("Ticket price not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public TicketPrice addNewTicketPrice(TicketPriceRequest ticketPriceRequest) {
        return ticketPriceRepository.save(toEntity(ticketPriceRequest));
    }

    @Override
    public TicketPrice updateTicketPrice(TicketPriceRequest ticketPriceRequest, Long updateId) throws CustomException {
        TicketPrice ticketPriceUpdate = findById(updateId);
        ticketPriceUpdate.setStandardPrice(ticketPriceRequest.getStandardPrice());
        ticketPriceUpdate.setSweetboxPrice(ticketPriceRequest.getSweetboxPrice());
        ticketPriceUpdate.setVipPrice(ticketPriceRequest.getVipPrice());
        ticketPriceUpdate.setTimePeriod(ticketPriceRequest.getTimePeriod());
        ticketPriceUpdate.setWeekendRate(ticketPriceRequest.getWeekendRate());

        return ticketPriceRepository.save(ticketPriceUpdate);
    }

    @Override
    public void deleteByIdTicketPrice(Long deleteId) throws CustomException {
        if (ticketPriceRepository.existsById(deleteId)) {
            ticketPriceRepository.deleteById(deleteId);
        } else {
            throw new CustomException("Ticket price not found", HttpStatus.NOT_FOUND);
        }
    }

    private TicketPrice toEntity(TicketPriceRequest ticketPriceRequest) {
        return TicketPrice.builder()
                .standardPrice(ticketPriceRequest.getStandardPrice())
                .sweetboxPrice(ticketPriceRequest.getSweetboxPrice())
                .vipPrice(ticketPriceRequest.getVipPrice())
                .timePeriod(ticketPriceRequest.getTimePeriod())
                .weekendRate(ticketPriceRequest.getWeekendRate())
                .build();
    }
}