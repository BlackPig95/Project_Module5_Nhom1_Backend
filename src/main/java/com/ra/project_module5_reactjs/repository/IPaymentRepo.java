package com.ra.project_module5_reactjs.repository;

import com.ra.project_module5_reactjs.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPaymentRepo extends JpaRepository<Payment, Long>
{
    List<Payment> findAllByBooking_Id(Long bookingId);
}
