package com.ra.project_module5_reactjs.repository;

import com.ra.project_module5_reactjs.model.entity.TicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITicketPriceRepository extends JpaRepository<TicketPrice,Long> {
}
