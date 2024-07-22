package com.ra.project_module5_reactjs.service.implementation.admin;

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
@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements IDiscountService {
    private final IDiscountRepo discountRepo;

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
    public Discount addNewDiscount(DiscountRequest discountRequest) {
        return discountRepo.save(toEntity(discountRequest));
    }

    @Override
    public Discount updateDiscount(DiscountRequest discountRequest, Long updateId) throws CustomException {
        Discount discountUpdate = findById(updateId);
        discountUpdate.setCode(discountRequest.getCode());
        discountUpdate.setDescription(discountRequest.getDescription());
        discountUpdate.setDiscountPercentage(Double.valueOf(discountRequest.getDiscountPercentage()));
        discountUpdate.setIsUsed(discountRequest.getIsUsed());
        discountUpdate.setValidFrom(discountRequest.getValidFrom());
        discountUpdate.setValidTo(discountRequest.getValidTo());

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

    private Discount toEntity(DiscountRequest discountRequest) {
        return Discount.builder()
                .code(discountRequest.getCode())
                .description(discountRequest.getDescription())
                .discountPercentage(Double.valueOf(discountRequest.getDiscountPercentage()))
                .isUsed(discountRequest.getIsUsed())
                .validFrom(discountRequest.getValidFrom())
                .validTo(discountRequest.getValidTo())
                .build();
    }
}
