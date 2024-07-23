package com.ra.project_module5_reactjs.repository;

import com.ra.project_module5_reactjs.model.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IShowtimeRepo extends JpaRepository<Showtime, Long>
{
    boolean existsByMovie_Id(Long movieId);
    List<Showtime> findShowtimeByMovieId(Long movieId);
}
