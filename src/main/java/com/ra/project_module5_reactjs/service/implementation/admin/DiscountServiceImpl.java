package com.ra.project_module5_reactjs.service.implementation.admin;

import com.ra.project_module5_reactjs.config.FileService;
import com.ra.project_module5_reactjs.exception.CustomException;
import com.ra.project_module5_reactjs.model.dto.request.DiscountRequest;
import com.ra.project_module5_reactjs.model.entity.Discount;
import com.ra.project_module5_reactjs.repository.IDiscountRepo;
import com.ra.project_module5_reactjs.service.design.admin.IDiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements IDiscountService {
    private final IDiscountRepo discountRepo;
    private final FileService fileService;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Page<Discount> findAllDiscount(Pageable pageable) {
        return discountRepo.findAll(pageable);
    }

    @Override
    public Discount findById(Long findId) throws CustomException {
        return discountRepo.findById(findId)
                .orElseThrow(() -> new CustomException("discount not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public Discount addNewDiscount(DiscountRequest discountRequest) throws ParseException {
        return discountRepo.save(toEntity(discountRequest));
    }

    @Override
    public Discount updateDiscount(DiscountRequest discountRequest, Long updateId) throws CustomException, ParseException {
        Discount discountUpdate = findById(updateId);
        discountUpdate.setCode(discountRequest.getCode());
        discountUpdate.setDescription(discountRequest.getDescription());
        discountUpdate.setDiscountPercentage(discountRequest.getDiscountPercentage());
        discountUpdate.setImageUrl(discountRequest.getImageUrl() !=null ? fileService.uploadFileToServer(discountRequest.getImageUrl()) : discountUpdate.getImageUrl());
        discountUpdate.setIsUsed(discountRequest.getIsUsed());
        discountUpdate.setValidFrom(sdf.parse(discountRequest.getValidFrom()));
        discountUpdate.setValidTo(sdf.parse(discountRequest.getValidTo()));

        return discountRepo.save(discountUpdate);
    }

    @Override
    public void deleteByIdDiscount(Long deleteId) throws CustomException {
        if (discountRepo.existsById(deleteId)) {
            discountRepo.deleteById(deleteId);
        } else {
            throw new CustomException("discount not found", HttpStatus.NOT_FOUND);
        }
    }

    private Discount toEntity(DiscountRequest discountRequest) throws ParseException {
        return Discount.builder()
                .code(discountRequest.getCode())
                .description(discountRequest.getDescription())
                .discountPercentage(discountRequest.getDiscountPercentage())
                .imageUrl(fileService.uploadFileToServer(discountRequest.getImageUrl()))
                .isUsed(discountRequest.getIsUsed())
                .validFrom(sdf.parse(discountRequest.getValidFrom()))
                .validTo(sdf.parse(discountRequest.getValidTo()))
                .build();
    }
}
