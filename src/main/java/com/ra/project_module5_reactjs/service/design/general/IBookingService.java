package com.ra.project_module5_reactjs.service.design.general;

import com.ra.project_module5_reactjs.model.entity.Booking;

import java.util.List;

public interface IBookingService
{
    List<Booking> findBookingsByUserId(Long userId);
}
