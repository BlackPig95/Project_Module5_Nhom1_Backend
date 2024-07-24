package com.ra.project_module5_reactjs.repository;

import com.ra.project_module5_reactjs.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookingRepo extends JpaRepository<Booking, Long>
{
    List<Booking> findAllByUser_Id(Long userId);
}
