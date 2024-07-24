package com.ra.project_module5_reactjs.service.design.client;

import com.ra.project_module5_reactjs.model.entity.Payment;

import java.util.List;

public interface IPaymentService
{
    List<Payment> findPaymentHistoryByBookingId(Long bookingId);
}
