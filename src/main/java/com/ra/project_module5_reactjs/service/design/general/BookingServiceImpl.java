package com.ra.project_module5_reactjs.service.design.general;

import com.ra.project_module5_reactjs.model.entity.Booking;
import com.ra.project_module5_reactjs.repository.IBookingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements IBookingService
{
    private final IBookingRepo bookingRepo;

    @Override
    public List<Booking> findBookingsByUserId(Long userId)
    {
        return bookingRepo.findAllByUser_Id(userId);
    }
}
