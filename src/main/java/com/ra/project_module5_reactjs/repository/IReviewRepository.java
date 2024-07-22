package com.ra.project_module5_reactjs.repository;


import com.ra.project_module5_reactjs.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReviewRepository extends JpaRepository<Review, Long>
{
    boolean existsByMovieId(Long movieId);
}
