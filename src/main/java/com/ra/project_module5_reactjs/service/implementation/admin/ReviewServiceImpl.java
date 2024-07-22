package com.ra.project_module5_reactjs.service.implementation.admin;

import com.ra.project_module5_reactjs.model.entity.Review;
import com.ra.project_module5_reactjs.repository.IReviewRepository;
import com.ra.project_module5_reactjs.service.design.admin.IReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements IReviewService {
    private final IReviewRepository repository;
    @Override
    public void updateReview(Review review) {
        repository.save(review);
    }

    @Override
    public List<Review> getAllReview() {
        return repository.findAll();
    }
}
