package com.ra.project_module5_reactjs.repository;

import com.ra.project_module5_reactjs.model.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiscountRepo extends JpaRepository<Discount,Long> {
}
