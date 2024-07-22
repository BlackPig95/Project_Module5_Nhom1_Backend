package com.ra.project_module5_reactjs.repository;

import com.ra.project_module5_reactjs.model.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShowtimeRepo extends JpaRepository<Showtime, Long>
{
    boolean existsByMovie_Id(Long movieId);
}
