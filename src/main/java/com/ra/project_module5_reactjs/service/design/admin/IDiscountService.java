package com.ra.project_module5_reactjs.service.design.admin;

import com.ra.project_module5_reactjs.exception.CustomException;
import com.ra.project_module5_reactjs.model.dto.request.DiscountRequest;
import com.ra.project_module5_reactjs.model.entity.Discount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;

public interface IDiscountService {
    Page<Discount> findAllDiscount(Pageable pageable);
    Discount findById(Long findId) throws CustomException;
    Discount addNewDiscount(DiscountRequest discountRequest) throws ParseException;
    Discount updateDiscount(DiscountRequest discountRequest,Long updateId) throws CustomException , ParseException;
    void deleteByIdDiscount(Long deleteId) throws CustomException;
}
