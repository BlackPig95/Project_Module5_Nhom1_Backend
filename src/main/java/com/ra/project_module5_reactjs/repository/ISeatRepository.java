package com.ra.project_module5_reactjs.repository;

import com.ra.project_module5_reactjs.model.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeatRepository extends JpaRepository<Seat, Long> {
}
