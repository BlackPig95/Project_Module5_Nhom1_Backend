package com.ra.project_module5_reactjs.service.implementation.client;

import com.ra.project_module5_reactjs.model.entity.Payment;
import com.ra.project_module5_reactjs.repository.IPaymentRepo;
import com.ra.project_module5_reactjs.service.design.client.IPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements IPaymentService
{
    private final IPaymentRepo paymentRepo;

    @Override
    public List<Payment> findPaymentHistoryByBookingId(Long bookingId)
    {
        return paymentRepo.findAllByBooking_Id(bookingId);
    }
}
