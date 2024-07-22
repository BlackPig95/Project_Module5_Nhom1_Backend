package com.ra.project_module5_reactjs.service.design.admin;

import com.ra.project_module5_reactjs.model.entity.Review;

import java.util.List;

public interface IReviewService  {

     void updateReview(Review review);
    List<Review> getAllReview();
}
